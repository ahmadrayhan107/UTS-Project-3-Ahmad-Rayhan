<?php

namespace App\Http\Controllers;

use App\Models\PendaftaranTemu;
use App\Models\RekamMedis;
use Illuminate\Http\Request;
use Illuminate\Support\Str;

class RekamMedisController extends Controller
{
    public function create($id)
    {
        $pendaftaranTemu = PendaftaranTemu::find($id);
        return view('petugas_medis.rekam-medis.create', ['pendaftaranTemu' => $pendaftaranTemu]);
    }

    public function store(Request $request, PendaftaranTemu $pendaftaranTemu)
    {
        $validateData = $request->validate([
            'tanggal_periksa' => 'required|date',
            'keluhan' => 'required|max:30',
            'diagnosa' => 'required|max:30',
            'tekanan_darah' => 'required|max_digits:5|numeric',
            'suhu_tubuh' => 'required|max_digits:5|numeric',
            'berat_badan' => 'required|max_digits:5|numeric'
        ]);

        $lastKodeRekamMedis = RekamMedis::orderBy('id_rekam_medis', 'desc')->first();
        if (!$lastKodeRekamMedis) {
            $validateData['kode_rekam_medis'] = 'RM001';
        } else {
            $lastNumber = (int) Str::remove('RM', $lastKodeRekamMedis->kode_rekam_medis);
            if ($lastNumber >= 99) {
                $validateData['kode_rekam_medis'] = 'RM' . $lastNumber + 1;
            } elseif ($lastNumber >= 9) {
                $validateData['kode_rekam_medis'] = 'RM0' . $lastNumber + 1;
            } else {
                $validateData['kode_rekam_medis'] = 'RM00' . $lastNumber + 1;
            }
        }

        $validateData['pasien_id'] = $pendaftaranTemu->pasien_id;
        $validateData['pendaftaran_temu_id'] = $pendaftaranTemu->id_pendaftaran_temu;

        RekamMedis::create($validateData);

        $rekamMedis = RekamMedis::where('kode_rekam_medis', $validateData['kode_rekam_medis'])->first();

        $id = $rekamMedis->id_rekam_medis;

        return redirect(route('resep-obat.create', ['pendaftaranTemu' => $pendaftaranTemu, 'id' => $id]));
    }

    public function show($id)
    {
        $rekamMedis = RekamMedis::find($id);
        return view('admin.rekam-medis.show', ['rekamMedis' => $rekamMedis]);
    }
}
