<?php

namespace App\Http\Controllers;

use App\Models\PendaftaranTemu;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Validator;

class ResepObatApiController extends Controller
{
    public function store(Request $request)
    {
        $validateData = Validator::make($request->all(), [
            'tanggal' => 'required|date',
            'dosis' => 'required|max:10',
            'jenis_obat' => 'required|max:15',
            'keterangan' => 'required|max:30',
            'obat_id' => 'required',
            'pendaftaran_temu_id' => 'required'
        ]);

        if ($validateData->fails()) {
            return response()->json([
                'errors' => $validateData->errors(),
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }

        $dataResepObat = $request->all();

        PendaftaranTemu::where('id_pendaftaran_temu', $dataResepObat['pendaftaran_temu_id'])
            ->update(['status' => 'Selesai']);

        return response()->json([
            'message' => 'Resep obat telah dibuat',
            'status' => Response::HTTP_CREATED,
        ], Response::HTTP_CREATED);
    }
}
