<?php

namespace App\Http\Controllers\api;

use App\Http\Controllers\Controller;
use App\Models\Dokter;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Validator;
use Illuminate\Validation\Rule;

class DokterController extends Controller
{
    public function show($id)
    {
        $dokter = Dokter::where('user_id', $id)->first();

        if (!$dokter) {
            return response()->json([
                'errors' => 'The doctor doesnt exist',
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }

        $dataDokter = $dokter->load(['user']);

        return response()->json([
            'dataDokter' => $dataDokter,
            'status' => Response::HTTP_OK,
        ], Response::HTTP_OK);
    }

    public function store(Request $request)
    {
        $validateData = Validator::make($request->all(), [
            'nama_dokter' => 'required|max:30',
            'nip' => 'required|size:18|unique:dokters,nip',
            'jenis_kelamin' => 'required|max:10',
            'spesialis' => 'required|max:15',
            'no_hp' => 'required|max:15|unique:dokters,no_hp',
            'alamat' => 'required|max:50',
            'user_id' => 'required|max:10|unique:dokters,user_id'
        ]);

        if ($validateData->fails()) {
            return response()->json([
                'errors' => $validateData->errors(),
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }

        $dataDokter = $request->all();
        Dokter::create($dataDokter);

        return response()->json([
            'message' => 'Created data successfully',
            'status' => Response::HTTP_CREATED,
        ], Response::HTTP_CREATED);
    }

    public function update(Request $request, $id)
    {
        $dokter = Dokter::find($id);
        if (!$dokter) {
            return response()->json([
                'errors' => 'The doctor doesnt exist',
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }

        $validateData = Validator::make($request->all(), [
            'nama_dokter' => 'required|max:30',
            'nip' => [
                'required',
                'size:18',
                Rule::unique('dokters', 'nip')->ignore($id, 'id_dokter')
            ],
            'jenis_kelamin' => 'required|max:10',
            'spesialis' => 'required|max:15',
            'no_hp' => [
                'required',
                'max:15',
                Rule::unique('dokters', 'no_hp')->ignore($id, 'id_dokter')
            ],
            'alamat' => 'required|max:50'

        ]);

        if ($validateData->fails()) {
            return response()->json([
                'errors' => $validateData->errors(),
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }

        $dataDokter = $request->all();
        Dokter::where('id_dokter', $id)->update($dataDokter);

        return response()->json([
            'message' => 'Updated data successfully',
            'status' => Response::HTTP_OK,
        ], Response::HTTP_OK);
    }
}
