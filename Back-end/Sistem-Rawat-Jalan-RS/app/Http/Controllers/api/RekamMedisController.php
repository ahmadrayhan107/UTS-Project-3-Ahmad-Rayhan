<?php

namespace App\Http\Controllers\api;

use App\Http\Controllers\Controller;
use App\Models\RekamMedis;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class RekamMedisController extends Controller
{
    public function show($id)
    {
        $rekamMedis = RekamMedis::where('pasien_id', $id)->get();

        $dataRekamMedis = $rekamMedis->load(['resepObat']);


        return response()->json([
            'rekamMedis' => $dataRekamMedis,
            'status' => Response::HTTP_OK,
        ], Response::HTTP_OK);
    }
}
