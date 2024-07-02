<?php

namespace App\Http\Controllers\api;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Validator;

class AttachmentsController extends Controller
{
    public function uploadImage(Request $request, $id)
    {
        $validateData = Validator::make($request->all(), [
            'img_profile' => 'required|image|mimes:png,jpg'
        ]);

        if ($validateData->fails()) {
            $errors = $validateData->errors();

            if ($errors->first('img_profile')) {
                $message = $errors->first('img_profile');
            }

            return response()->json([
                'message' => $message,
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }

        $namaFile = '/img/profiles/img_' . time();
        $request->img_profile->move('img/profiles', $namaFile);
        User::where('id_user', $id)->update(['img_profile' => $namaFile]);

        return response()->json([
            'message' => 'Uploaded success',
            'status' => Response::HTTP_CREATED,
        ], Response::HTTP_CREATED);
    }
}
