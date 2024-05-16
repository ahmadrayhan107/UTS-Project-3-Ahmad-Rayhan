<?php

namespace App\Http\Controllers;

use App\Models\Apoteker;
use App\Models\Dokter;
use App\Models\JadwalDokter;
use App\Models\Pasien;
use App\Models\Pembayaran;
use App\Models\PendaftaranTemu;
use App\Models\PetugasMedis;
use App\Models\User;
use Carbon\Carbon;

class DashboardController extends Controller
{
    public function index()
    {
        if (Auth()->user()->role === 'Admin') {
            $countUsers = User::count();
            $countPasien = Pasien::count();
            $countDokter = Dokter::count();
            $countPetugasMedis = PetugasMedis::count();
            $countApoteker = Apoteker::count();
            $countJadwalDokter = JadwalDokter::count();
            $countPendingJadwalDokter = JadwalDokter::where('status', 'Pending')->count();
            $countAcceptedJadwalDokter = JadwalDokter::where('status', 'Accepted')->count();
            $countCanceledJadwalDokter = JadwalDokter::where('status', 'Canceled')->count();
            $pembayarans = Pembayaran::all();

            $totalPenghasilan = 0;
            foreach ($pembayarans as $pembayaran) {
                $totalPenghasilan = $totalPenghasilan + $pembayaran->total_biaya;
            }

            return view(
                'dashboard',
                [
                    'countUsers' => $countUsers,
                    'countPasien' => $countPasien,
                    'countDokter' => $countDokter,
                    'countPetugasMedis' => $countPetugasMedis,
                    'countApoteker' => $countApoteker,
                    'countJadwalDokter' => $countJadwalDokter,
                    'countPendingJadwalDokter' => $countPendingJadwalDokter,
                    'countAcceptedJadwalDokter' => $countAcceptedJadwalDokter,
                    'countCanceledJadwalDokter' => $countCanceledJadwalDokter,
                    'totalPenghasilan' => $totalPenghasilan
                ]
            );
        } else if (Auth()->user()->role === 'Petugas Medis') {
            $dateNow = Carbon::now();

            $pendaftaranTemus = PendaftaranTemu::where('status', 'Terdaftar')
                ->where('tanggal_pendaftaran', $dateNow->toDateString())
                ->get();
            return view('dashboard', ['pendaftaranTemus' => $pendaftaranTemus]);
        } else if (Auth()->user()->role === 'Apoteker') {
            $dateNow = Carbon::now();

            $pendaftaranTemus = PendaftaranTemu::where('status', 'Selesai')
                ->get();
            return view('dashboard', ['pendaftaranTemus' => $pendaftaranTemus]);
        }
    }
}
