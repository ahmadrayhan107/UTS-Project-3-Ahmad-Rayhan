<?php

namespace App\Http\Controllers;

use App\Models\Obat;
use App\Models\PendaftaranTemu;
use App\Models\RekamMedis;
use Illuminate\Http\Request;

class ObatController extends Controller
{
    public function index()
    {
        $obats = Obat::all();
        return view('apoteker.obats.index', ['obats' => $obats]);
    }

    public function create()
    {
        return view('apoteker.obats.create');
    }

    public function store(Request $request)
    {
        $validateData = $request->validate([
            'nama_obat' => 'required|max:30',
            'harga_obat' => 'required',
            'status' => 'required|filled|max:15'
        ]);

        Obat::create($validateData);

        return redirect('/obat')->with('pesan', 'Data saved successfully');
    }

    public function edit($id)
    {
        $obat = Obat::find($id);
        return view('apoteker.obats.edit', ['obat' => $obat]);
    }

    public function update(Request $request, $id)
    {
        $validateData = $request->validate([
            'nama_obat' => 'required|max:30',
            'harga_obat' => 'required',
            'status' => 'required|filled|max:15'
        ]);

        Obat::find($id)->update($validateData);

        return redirect('/obat')->with('pesan', 'Data updated successfully');
    }

    public function destroy($id)
    {
        Obat::destroy($id);
        return redirect('/obat')->with('pesan', 'Data deleted successfully');
    }

    public function info($id)
    {
        $daftarObats = RekamMedis::where('pendaftaran_temu_id', $id)->get();

        return view('apoteker.obats.info', ['daftarObats' => $daftarObats]);
    }

    public function success($id)
    {
        PendaftaranTemu::where('id_pendaftaran_temu', $id)->update(['status' => 'Success']);
        return redirect('/dashboard')->with('pesan', 'Obat provide successfully');
    }
}
