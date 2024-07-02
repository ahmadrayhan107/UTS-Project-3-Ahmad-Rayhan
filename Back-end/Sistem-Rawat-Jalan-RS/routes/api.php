<?php

use App\Http\Controllers\api\AttachmentsController;
use App\Http\Controllers\api\AuthController;
use App\Http\Controllers\api\DokterController;
use App\Http\Controllers\api\JadwalDokterController;
use App\Http\Controllers\api\PasienController;
use App\Http\Controllers\api\PendaftaraanTemuController;
use App\Http\Controllers\api\RekamMedisController;
use App\Http\Controllers\api\PembayaranController;
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
    Route::post('/login', [AuthController::class, 'login']);
    Route::post('/register', [AuthController::class, 'register']);
    Route::post('/logout', [AuthController::class, 'logout']);

    Route::middleware('auth.api')->group(function () {
        // Pasien
        Route::get('/pasien/{id}', [PasienController::class, 'show']);
        Route::post('/pasien', [PasienController::class, 'store']);
        Route::put('/pasien/{id}', [PasienController::class, 'update']);

        // Dokter
        Route::get('/dokter', [DokterController::class, 'index']);
        Route::get('/dokter/{id}', [DokterController::class, 'show']);
        Route::post('/dokter', [DokterController::class, 'store']);
        Route::put('/dokter/{id}', [DokterController::class, 'update']);

        // Jadwal Dokter
        Route::get('/jadwal-dokter', [JadwalDokterController::class, 'index']);
        Route::get('/jadwal-dokter/{id}', [JadwalDokterController::class, 'show']);
        Route::post('/jadwal-dokter', [JadwalDokterController::class, 'store']);
        Route::put('/jadwal-dokter/{id}', [JadwalDokterController::class, 'update']);

        // Pendaftaran Temu
        Route::get('/pasiens-by-dokter/{id}', [PendaftaraanTemuController::class, 'getPasiensbyDokter']);
        Route::post('/pendaftaran-temu/{id}', [PendaftaraanTemuController::class, 'store']);
        Route::get('/pendaftaran-temu/{id}', [PendaftaraanTemuController::class, 'show']);

        // Rekam Medis
        Route::get('/rekam-medis/{id}', [RekamMedisController::class, 'show']);
        Route::get('/rekam-medis/detail/{id}', [RekamMedisController::class, 'showDetail']);

        // Pembayaran
        Route::get('/pembayaran/{id}/list', [PembayaranController::class, 'show']);

        // Attachments
        Route::post('/attachments/{id}', [AttachmentsController::class, 'uploadImage']);
    });

    // Xendit
    Route::post('/pembayaran', [PembayaranController::class, 'create']);
    Route::post('/pembayaran/webhook/xendit', [PembayaranController::class, 'webhook']);
});
