<?php

namespace App\Http\Controllers;

use App\Models\Obat;
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
}
