<?php

use App\Http\Controllers\AuthApiController;
use App\Http\Controllers\DokterApiController;
use App\Http\Controllers\JadwalDokterApiController;
use App\Http\Controllers\PasienApiController;
use App\Http\Controllers\PendaftaranTemuApiController;
use App\Http\Controllers\RekamMedisApiController;
use App\Http\Controllers\ResepObatApiController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::group(array('prefix' => 'v1'), function () {

    // Auth
    Route::post('/login', [AuthApiController::class, 'login']);
    Route::post('/register', [AuthApiController::class, 'register']);
    Route::post('/logout', [AuthApiController::class, 'logout']);

    Route::middleware('auth.api')->group(function () {
        // Pasien
        Route::get('/pasien/{id}', [PasienApiController::class, 'show']);
        Route::post('/pasien', [PasienApiController::class, 'store']);
        Route::put('/pasien/{id}', [PasienApiController::class, 'update']);

        // Dokter
        Route::get('/dokter/{id}', [DokterApiController::class, 'show']);
        Route::post('/dokter', [DokterApiController::class, 'store']);
        Route::put('/dokter/{id}', [DokterApiController::class, 'update']);

        // Jadwal Dokter
        Route::get('/jadwal-dokter', [JadwalDokterApiController::class, 'index']);
        Route::get('/jadwal-dokter/{id}', [JadwalDokterApiController::class, 'show']);
        Route::post('/jadwal-dokter', [JadwalDokterApiController::class, 'store']);
        Route::put('/jadwal-dokter/{id}', [JadwalDokterApiController::class, 'update']);

        // Pendaftaran Temu
        Route::post('/pendaftaran-temu/{id}', [PendaftaranTemuApiController::class, 'store']);

        // Rekam Medis
        Route::get('/rekam-medis/{id}', [RekamMedisApiController::class, 'show']);

        // Resep Obat
        Route::post('/resep-obat', [ResepObatApiController::class, 'store']);
    });
});
