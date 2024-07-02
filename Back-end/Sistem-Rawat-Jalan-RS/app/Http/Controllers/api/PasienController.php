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
            'no_bpjs' => [
                'required',
                'size:11',
                Rule::unique('pasiens', 'no_bpjs')->ignore($id, 'id_pasien')
            ],
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
            $errors = $validateData->errors();

            if ($errors->first('nama_pasien')) {
                $message = $errors->first('nama_pasien');
            } else if ($errors->first('no_bpjs')) {
                $message = $errors->first('no_bpjs');
            } else if ($errors->first('nik')) {
                $message = $errors->first('nik');
            } else if ($errors->first('jenis_kelamin')) {
                $message = $errors->first('jenis_kelamin');
            } else if ($errors->first('tempat_lahir')) {
                $message = $errors->first('tempat_lahir');
            } else if ($errors->first('tanggal_lahir')) {
                $message = $errors->first('tanggal_lahir');
            } else if ($errors->first('no_hp')) {
                $message = $errors->first('no_hp');
            } else if ($errors->first('alamat')) {
                $message = $errors->first('alamat');
            }

            return response()->json([
                'message' => $message,
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
