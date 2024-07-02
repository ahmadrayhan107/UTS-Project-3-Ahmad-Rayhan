<?php

namespace App\Http\Controllers\api;

use App\Http\Controllers\Controller;
use App\Http\Resources\DetailRekamMedisResource;
use App\Http\Resources\RekamMedisResource;
use App\Models\RekamMedis;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class RekamMedisController extends Controller
{
    public function show($id)
    {
        $rekamMedis = RekamMedis::where('pasien_id', $id)->get();

        if (count($rekamMedis) === 0) {
            return response()->json([
                'message' => 'Anda belum melakukan pemeriksaan medis',
                'status' => Response::HTTP_NOT_FOUND,
            ], Response::HTTP_NOT_FOUND);
        }

        $dataRekamMedis = RekamMedisResource::collection($rekamMedis);

        return response()->json([
            'rekamMedis' => $dataRekamMedis,
            'status' => Response::HTTP_OK,
        ], Response::HTTP_OK);
    }

    public function showDetail($id)
    {
        $rekamMedis = RekamMedis::where('id_rekam_medis', $id)->first();

        $dataRekamMedis =   new DetailRekamMedisResource($rekamMedis);

        return response()->json([
            'rekamMedis' => $dataRekamMedis,
            'status' => Response::HTTP_OK,
        ], Response::HTTP_OK);
    }
}
