<?php

namespace App\Http\Controllers\api;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Validator;

class AuthController extends Controller
{
    public function login(Request $request)
    {
        $validateData = Validator::make($request->all(), [
            'email' => 'required|string|email',
            'password' => 'required|string|min:8',
        ]);

        if ($validateData->fails()) {
            return response()->json([
                'errors' => "Login is failed",
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }

        $credentials = $request->only('email', 'password');
        $token = Auth::guard('api')->attempt($credentials);

        if (!$token) {
            return response()->json([
                'message' => 'The user doesnt exist',
                'status' => Response::HTTP_UNAUTHORIZED,
            ], Response::HTTP_UNAUTHORIZED);
        }

        $last_login = now();
        User::where('email', $credentials['email'])->update(['last_login' => $last_login]);

        $dataUser = Auth::guard('api')->user();
        if ($dataUser) {
            return response()->json([
                'message' => "Login is successfully",
                'dataUser' => $dataUser,
                'authorization' => [
                    'token' => $token,
                    'type' => 'Bearer'
                ],
                'status' => Response::HTTP_OK,
            ], Response::HTTP_OK);
        }
    }

    public function register(Request $request)
    {
        $validateData = Validator::make($request->all(), [
            'username' => 'required|max:30',
            'email' => 'required|email|unique:users,email',
            'password' => 'required|min:8'
        ]);

        if ($validateData->fails()) {
            return response()->json([
                'errors' => $validateData->errors(),
                'status' => Response::HTTP_BAD_REQUEST,
            ], Response::HTTP_BAD_REQUEST);
        }

        $dataUser = $request->all();
        $dataUser['password'] = Hash::make($request->password);
        $dataUser['role'] = 'Pasien';
        User::create($dataUser);

        return response()->json([
            'message' => 'Register data successfully',
            'status' => Response::HTTP_CREATED,
        ], Response::HTTP_CREATED);
    }
}
