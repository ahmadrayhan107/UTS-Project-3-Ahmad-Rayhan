<?php

namespace App\Http\Controllers;

use App\Models\Dokter;
use App\Models\JadwalDokter;
use Carbon\Carbon;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Validator;

class JadwalDokterApiController extends Controller
{
    public function index()
    {
        $dokter = Dokter::all();
        $dataJadwalDokter = $dokter->load(['jadwalDokter']);

        return response()->json([
            'jadwalDokter' => $dataJadwalDokter,
            'status' => Response::HTTP_OK,
        ], Response::HTTP_OK);
    }

    public function show($id)
    {
        $jadwalDokter = JadwalDokter::where([
            'dokter_id' => $id,
            'status' => 'Accepted'
        ])->get();

        return response()->json([
            'jadwalDokter' => $jadwalDokter,
            'status' => Response::HTTP_OK,
        ], Response::HTTP_OK);
    }

    public function store(Request $request)
    {
        $validateData = Validator::make($request->all(), [
            'hari' => 'required|max:10',
            'jam_awal' => 'required',
            'jam_akhir' => 'required',
            'dokter_id' => 'required'
        ]);

        if ($validateData->fails()) {
            return response()->json([
                'errors' => $validateData->errors(),
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }

        $dataJadwalDokter = $request->all();
        $dataJadwalDokter['status'] = 'Pending';
        $dataJadwalDokter['seen'] = false;
        JadwalDokter::create($dataJadwalDokter);

        return response()->json([
            'message' => 'Created data successfully',
            'status' => Response::HTTP_CREATED,
        ], Response::HTTP_CREATED);
    }

    public function update(Request $request, $id)
    {
        $validateData = Validator::make($request->all(), [
            'hari' => 'required|max:10',
            'jam_awal' => 'required',
            'jam_akhir' => 'required'
        ]);

        if ($validateData->fails()) {
            return response()->json([
                'errors' => $validateData->errors(),
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }

        $dataJadwalDokter = $request->all();
        $dataJadwalDokter['status'] = 'Pending';
        $dataJadwalDokter['seen'] = false;
        JadwalDokter::find($id)->update($dataJadwalDokter);

        return response()->json([
            'message' => 'Updated data successfully',
            'status' => Response::HTTP_OK,
        ], Response::HTTP_OK);
    }
}
