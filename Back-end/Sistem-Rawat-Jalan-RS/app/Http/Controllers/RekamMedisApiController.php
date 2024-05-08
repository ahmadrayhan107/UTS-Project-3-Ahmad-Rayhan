<?php

namespace App\Http\Controllers;

use App\Models\RekamMedis;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class RekamMedisApiController extends Controller
{
    public function show($id)
    {
        $rekamMedis = RekamMedis::where('pasien_id', $id);

        return response()->json([
            'rekamMedis' => $rekamMedis,
            'status' => Response::HTTP_OK,
        ], Response::HTTP_OK);
    }
}
