<?php

namespace App\Http\Controllers\api;

use App\Http\Controllers\Controller;
use App\Models\JadwalDokter;
use App\Models\PendaftaranTemu;
use Carbon\Carbon;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Validator;
use Illuminate\Support\Str;

class PendaftaraanTemuController extends Controller
{
    public function store(Request $request, $id)
    {
        $validateData = Validator::make($request->all(), [
            'tanggal_pendaftaran' => 'required|date',
            'jam' => 'required',
            'pasien_id' => 'required',
            'dokter_id' => 'required'
        ]);

        if ($validateData->fails()) {
            return response()->json([
                'errors' => $validateData->errors(),
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }

        $dataPendaftaranTemu = $request->all();

        $jamPendaftaran = new Carbon($dataPendaftaranTemu['jam']);
        $jadwalDokter = JadwalDokter::where('id_jadwal_dokter', $id)
            ->where('jam_awal', '<=', $jamPendaftaran->toTimeString())
            ->where('jam_akhir', '>=', $jamPendaftaran->toTimeString())
            ->where('status', 'Accepted')
            ->first();
        if (!$jadwalDokter) {
            return response()->json([
                'message' => 'jam yang anda inputkan diluar batas waktu dokter',
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }


        $hariPendaftaran = new Carbon($dataPendaftaranTemu['tanggal_pendaftaran']);
        if ($jadwalDokter->hari !== $hariPendaftaran->dayName) {
            return response()->json([
                'message' => 'tanggal yang anda inputkan diluar data jadwal dokter',
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }

        $pendaftaranTemu = PendaftaranTemu::where('tanggal_pendaftaran', $request['tanggal_pendaftaran'])
            ->orderBy('id_pendaftaran_temu', 'desc')
            ->first();
        if (!$pendaftaranTemu) {
            $dataPendaftaranTemu['no_pendaftaran'] = 'P001';
        } else {
            $lastNumber = (int)Str::remove('P', $pendaftaranTemu->no_pendaftaran);
            if ($lastNumber >= 99) {
                $dataPendaftaranTemu['no_pendaftaran'] = 'P' . $lastNumber + 1;
            } elseif ($lastNumber >= 9) {
                $dataPendaftaranTemu['no_pendaftaran'] = 'P0' . $lastNumber + 1;
            } else {
                $dataPendaftaranTemu['no_pendaftaran'] = 'P00' . $lastNumber + 1;
            }
        }

        $dataPendaftaranTemu['status'] = 'Terdaftar';

        PendaftaranTemu::create($dataPendaftaranTemu);

        return response()->json([
            'message' => 'Pendaftaran temu telah dibuat',
            'status' => Response::HTTP_CREATED,
        ], Response::HTTP_CREATED);
    }
}
