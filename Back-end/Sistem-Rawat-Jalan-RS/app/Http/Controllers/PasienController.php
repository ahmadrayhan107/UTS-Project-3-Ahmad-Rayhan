<?php

namespace App\Http\Controllers;

use App\Models\Pasien;
use Illuminate\Http\Request;

class PasienController extends Controller
{
    public function index()
    {
        $pasiens = Pasien::all();
        return view('admin.pasiens.index', ['pasiens' => $pasiens]);
    }

    public function create($id)
    {
        return view('admin.pasiens.create', ['id' => $id]);
    }

    public function store(Request $request, $id)
    {
        $validateData = $request->validate([
            'nama_pasien' => 'required|max:30',
            'nik' => 'required|numeric|digits:14|unique:pasiens,nik',
            'jenis_kelamin' => 'required|max:10',
            'tempat_lahir' => 'required|max:15',
            'tanggal_lahir' => 'required|date',
            'no_hp' => 'required|numeric|max_digits:15|unique:pasiens,no_hp',
            'alamat' => 'required|max:50'
        ]);

        $validateData['user_id'] = $id;

        Pasien::create($validateData);
        return redirect('/pasien')->with('pesan', 'Data Pasien created successfully');
    }


    public function show($id)
    {
        $pasien = Pasien::find($id);
        return view('admin.pasiens.show', ['pasien' => $pasien]);
    }
}
