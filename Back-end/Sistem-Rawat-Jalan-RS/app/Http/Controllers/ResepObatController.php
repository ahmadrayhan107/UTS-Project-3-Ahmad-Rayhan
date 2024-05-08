<?php

namespace App\Http\Controllers;

use App\Models\Obat;
use App\Models\PendaftaranTemu;
use App\Models\ResepObat;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;

class ResepObatController extends Controller
{
    public function create(PendaftaranTemu $pendaftaranTemu)
    {
        $obats = Obat::all();
        return view('petugas_medis.resep-obats.create', ['pendaftaranTemu' => $pendaftaranTemu, 'obats' => $obats]);
    }

    public function store(Request $request, PendaftaranTemu $pendaftaranTemu)
    {
        $dataResepObats = $request->all();

        foreach ($dataResepObats['obat_id'] as $item => $dataResepObat) {

            $resepObat = new ResepObat();
            $resepObat->obat_id = $dataResepObats['obat_id'][$item];
            $resepObat->dosis = $dataResepObats['dosis'][$item];
            $resepObat->jenis_obat = $dataResepObats['jenis_obat'][$item];
            $resepObat->keterangan = $dataResepObats['keterangan'][$item];
            $resepObat->pasien_id = $pendaftaranTemu->pasien_id;
            $resepObat->save();
        }

        PendaftaranTemu::find($pendaftaranTemu->id_pendaftaran_temu)->update(['status' => 'Pending']);

        return redirect('/dashboard')->with('pesan', 'Data saved successfully');
    }
}
