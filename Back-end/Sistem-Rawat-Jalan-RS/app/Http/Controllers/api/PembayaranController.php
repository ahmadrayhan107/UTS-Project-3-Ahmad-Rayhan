<?php

namespace App\Http\Controllers\api;

use App\Http\Controllers\Controller;
use App\Http\Resources\DetailResource;
use App\Http\Resources\PembayaranResource;
use App\Models\DetailPembayaran;
use App\Models\Pembayaran;
use App\Models\PendaftaranTemu;
use App\Models\RekamMedis;
use Carbon\Carbon;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Xendit\Configuration;
use Xendit\Invoice\CreateInvoiceRequest;
use Illuminate\Support\Str;
use Xendit\Invoice\InvoiceApi;

class PembayaranController extends Controller
{
    public function __construct()
    {
        Configuration::setXenditKey(env('XENDIT_API_KEY'));
    }

    public function show($id)
    {
        $daftarPembayaran = PendaftaranTemu::where('pasien_id', $id)->where('status', 'Pending')->get();
        if (!$daftarPembayaran) {
            return response()->json([
                'message' => 'Anda tidak memiliki tagihan',
                'status' => Response::HTTP_NOT_FOUND,
            ], Response::HTTP_NOT_FOUND);
        }

        $dataDaftarPembayaran = PembayaranResource::collection($daftarPembayaran);

        return response()->json([
            'daftarPembayaran' => $dataDaftarPembayaran,
            'status' => Response::HTTP_OK,
        ], Response::HTTP_OK);
    }

    public function create(Request $request)
    {
        $invoice = new InvoiceApi();

        $create_invoice_request = new CreateInvoiceRequest([
            'external_id' => (string) Str::uuid(),
            'amount' => $request->total_biaya
        ]);

        $createInvoice = $invoice->createInvoice($create_invoice_request);

        $nota = 'T' . date('YmdHis');

        // Save to database
        $pembayaran = new Pembayaran();
        $pembayaran->nota = $nota;
        $pembayaran->total_biaya = $request->total_biaya;
        $pembayaran->tanggal_pembayaran = Carbon::now()->toDateString();
        $pembayaran->pasien_id = $request->pasien_id;
        $pembayaran->checkout_link = $createInvoice['invoice_url'];
        $pembayaran->external_id = $create_invoice_request['external_id'];
        $pembayaran->status = 'Pending';
        $pembayaran->save();

        $pembayaran_id = Pembayaran::where('nota', $nota)->first()->id_pembayaran;

        $details = $request->details;

        foreach ($details as $detail) {
            $detailPembayaran = new DetailPembayaran();
            $detailPembayaran->nama_tagihan = $detail['nama_tagihan'];
            $detailPembayaran->biaya = $detail['biaya'];
            $detailPembayaran->pembayaran_id = $pembayaran_id;
            $detailPembayaran->save();
        }

        $detailPembayaran = new DetailPembayaran();
        $detailPembayaran->nama_tagihan = 'Layanan';
        $detailPembayaran->biaya = 50000;
        $detailPembayaran->pembayaran_id = $pembayaran_id;
        $detailPembayaran->save();

        PendaftaranTemu::where('id_pendaftaran_temu', $request->pendaftaran_temu_id)->update(['status' => 'Selesai']);

        return response()->json([
            'invoice_url' => $createInvoice['invoice_url'],
            'status' => Response::HTTP_OK,
        ], Response::HTTP_OK);
    }

    public function webhook(Request $request)
    {
        $invoice = new InvoiceApi();
        $getInvoice = $invoice->getInvoiceById($request->id);

        // Get data
        $pembayaran = Pembayaran::where('external_id', $request->external_id)->firstOrFail();

        if ($pembayaran->status == 'settled') {
            return response()->json(['message' => 'Payment has been already processed']);
        }

        // Update status payment
        $pembayaran->status = 'Finish';
        $pembayaran->save();

        return response()->json(['message' => 'Payment successfully']);
    }
}
