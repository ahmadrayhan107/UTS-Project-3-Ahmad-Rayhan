<?php

namespace App\Http\Controllers\api;

use App\Http\Controllers\Controller;
use App\Models\Pasien;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Validator;
use Illuminate\Validation\Rule;

class PasienController extends Controller
{
    public function show($id)
    {
        $pasien = Pasien::where('user_id', $id)->first();
        if (!$pasien) {
            return response()->json([
                'errors' => 'The patient doesnt exist',
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }

        $dataPasien = $pasien->load(['user']);

        return response()->json([
            'dataPasien' => $dataPasien,
            'status' => Response::HTTP_OK,
        ], Response::HTTP_OK);
    }

    public function store(Request $request)
    {
        $validateData = Validator::make($request->all(), [
            'nama_pasien' => 'required|max:30',
            'nik' => 'required|size:14|unique:pasiens,nik',
            'jenis_kelamin' => 'required|max:10',
            'tempat_lahir' => 'required|max:15',
            'tanggal_lahir' => 'required|date',
            'no_hp' => 'required|max:15|unique:pasiens,no_hp',
            'alamat' => 'required|max:50',
            'user_id' => 'required|max:10|unique:pasiens,user_id'
        ]);

        if ($validateData->fails()) {
            return response()->json([
                'errors' => $validateData->errors(),
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }

        $dataPasien = $request->all();
        Pasien::create($dataPasien);

        return response()->json([
            'message' => 'Created data successfully',
            'status' => Response::HTTP_CREATED,
        ], Response::HTTP_CREATED);
    }

    public function update(Request $request, $id)
    {
        $pasien = Pasien::find($id);
        if (!$pasien) {
            return response()->json([
                'errors' => 'The patient doesnt exist',
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }

        $validateData = Validator::make($request->all(), [
            'nama_pasien' => 'required|max:30',
            'nik' => [
                'required',
                'size:14',
                Rule::unique('pasiens', 'nik')->ignore($id, 'id_pasien')
            ],
            'jenis_kelamin' => 'required|max:10',
            'tempat_lahir' => 'required|max:15',
            'tanggal_lahir' => 'required|date',
            'no_hp' => [
                'required',
                'max:15',
                Rule::unique('pasiens', 'no_hp')->ignore($id, 'id_pasien')
            ],
            'alamat' => 'required|max:50'

        ]);

        if ($validateData->fails()) {
            return response()->json([
                'errors' => $validateData->errors(),
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }

        $dataPasien = $request->all();
        Pasien::where('id_pasien', $id)->update($dataPasien);

        return response()->json([
            'message' => 'Updated data successfully',
            'status' => Response::HTTP_OK,
        ], Response::HTTP_OK);
    }
}
