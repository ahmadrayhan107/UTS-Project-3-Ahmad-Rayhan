<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\AuthController;
use App\Http\Controllers\UserController;
use App\Http\Controllers\DokterController;
use App\Http\Controllers\PasienController;
use App\Http\Controllers\ProfileController;
use App\Http\Controllers\ApotekerController;
use App\Http\Controllers\DashboardController;
use App\Http\Controllers\RekamMedisController;
use App\Http\Controllers\JadwalDokterController;
use App\Http\Controllers\ObatController;
use App\Http\Controllers\PembayaranController;
use App\Http\Controllers\PetugasMedisController;
use App\Http\Controllers\PendaftaranTemuController;
use App\Http\Controllers\ResepObatController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "web" middleware group. Make something great!
|
*/

Route::middleware('auth')->group(function () {
    Route::get('/', function () {
        return redirect('/dashboard');
    });

    // Dashboard
    Route::get('/dashboard', [DashboardController::class, 'index'])->name('dashboard');

    Route::middleware('profile')->group(function () {
        // Profile
        Route::get('/profile', [ProfileController::class, 'index'])->name('profile');
        Route::post('/profile', [ProfileController::class, 'store'])->name('profile.create');
        Route::put('/profile/{id}', [ProfileController::class, 'update'])->name('profile.edit');
    });

    Route::middleware('admin')->group(function () {
        // Users
        Route::get('/users', [UserController::class, 'index'])->name('users.index');
        Route::get('/users/create', [UserController::class, 'create'])->name('users.create');
        Route::post('/users', [UserController::class, 'store'])->name('users.store');
        Route::delete('/users/{id}', [UserController::class, 'destroy'])->name('users.destroy');
        Route::get('/users/change-password', [UserController::class, 'changePassword'])->name('users.change-password');
        Route::post('/users/change-password', [UserController::class, 'changePasswordStore'])->name('users.change-password.store');

        // Dokter
        Route::get('/dokter', [DokterController::class, 'index'])->name('dokter.index');
        Route::get('/dokter/{id}/show', [DokterController::class, 'show'])->name('dokter.show');

        // Pasien
        Route::get('/pasien', [PasienController::class, 'index'])->name('pasien.index');
        Route::get('/pasien/{id}/create', [PasienController::class, 'create'])->name('pasien.create');
        Route::post('/pasien/{id}', [PasienController::class, 'store'])->name('pasien.store');
        Route::get('/pasien/{id}/show', [PasienController::class, 'show'])->name('pasien.show');

        // Rekam Medis
        Route::get('/rekam-medis/{id}/show', [RekamMedisController::class, 'show'])->name('rekam-medis.show');

        // Petugas Medis
        Route::get('/petugas-medis', [PetugasMedisController::class, 'index'])->name('petugas-medis.index');
        Route::get('/petugas-medis/{id}/show', [PetugasMedisController::class, 'show'])->name('petugas-medis.show');

        // Apoteker
        Route::get('/apoteker', [ApotekerController::class, 'index'])->name('apoteker.index');
        Route::get('/apoteker/{id}/show', [ApotekerController::class, 'show'])->name('apoteker.show');

        // Jadwal Dokter
        Route::get('/jadwal-dokter', [JadwalDokterController::class, 'index'])->name('jadwal-dokter.index');
        Route::get('/jadwal-dokter/pending', [JadwalDokterController::class, 'indexPending'])->name('jadwal-dokter.index.pending');
        Route::get('/jadwal-dokter/review/{id}', [JadwalDokterController::class, 'review'])->name('jadwal-dokter.review');
        Route::put('/jadwal-dokter/review/{id}', [JadwalDokterController::class, 'reviewStore'])->name('jadwal-dokter.review.store');

        // Pembayaran
        Route::get('/pembayaran', [PembayaranController::class, 'index'])->name('pembayaran.index');
        Route::get('/pembayaran/{id}/show', [PembayaranController::class, 'show'])->name('pembayaran.show');
    });

    Route::middleware('petugas-medis')->group(function () {
        // Rekam Medis
        Route::get('/rekam-medis/create/{id}', [RekamMedisController::class, 'create'])->name('rekam-medis.create');
        Route::post('/rekam-medis/store/{pendaftaranTemu}', [RekamMedisController::class, 'store'])->name('rekam-medis.store');

        // Resep 
        Route::get('/resep-obat/create/{pendaftaranTemu}/{id}', [ResepObatController::class, 'create'])->name('resep-obat.create');
        Route::post('/resep-obat/store/{pendaftaranTemu}{id}', [ResepObatController::class, 'store'])->name('resep-obat.store');

        // Pendaftaran Temu
        Route::get('/pendaftaran-temu', [PendaftaranTemuController::class, 'index'])->name('pendaftaran-temu');
    });

    Route::middleware('apoteker')->group(function () {
        // Obat
        Route::get('/obat', [ObatController::class, 'index'])->name('obat.index');
        Route::get('/obat/create', [ObatController::class, 'create'])->name('obat.create');
        Route::post('/obat', [ObatController::class, 'store'])->name('obat.store');
        Route::get('/obat/{id}', [ObatController::class, 'edit'])->name('obat.edit');
        Route::put('/obat/{id}', [ObatController::class, 'update'])->name('obat.update');
        Route::delete('/obat/{id}', [ObatController::class, 'destroy'])->name('obat.destroy');
        Route::get('/obat/{id}/info', [ObatController::class, 'info'])->name('obat.info');
        Route::post('/obat/{id}/success', [ObatController::class, 'success'])->name('obat.success');
    });
});

// Authentication Routes
Route::middleware('guest')->group(function () {
    Route::get('/login', [AuthController::class, 'login'])->name('auth.login');
    Route::post('/login', [AuthController::class, 'signin'])->name('auth.signin');
});
Route::post('/logout', [AuthController::class, 'logout'])->name('auth.logout');
