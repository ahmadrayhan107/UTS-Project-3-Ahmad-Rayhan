<?php

namespace App\Http\Controllers\api;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Validator;

class AttachmentsController extends Controller
{
    public function store(Request $request, $id)
    {
        $validateData = Validator::make($request->all(), [
            'img_profile' => 'required|image|mimes:png,jpg'
        ]);

        if ($validateData->fails()) {
            return response()->json([
                'errors' => $validateData->errors(),
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }

        $namaFile = 'http://127.0.0.1:8000/img/profiles/img_' . time() . '_' . $request->img_profile->getClientOriginalName();
        $request->img_profile->move('img/profiles', $namaFile);
        User::where('id_user', $id)->update(['img_profile' => $namaFile]);

        return response()->json([
            'img_url' => $namaFile,
            'status' => Response::HTTP_CREATED,
        ], Response::HTTP_CREATED);
    }
}
