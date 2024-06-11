<?php

namespace App\Http\Controllers;

use App\Models\JadwalDokter;
use Illuminate\Http\Request;

class JadwalDokterController extends Controller
{
    // public function index()
    // {
    //     $jadwalDokters = JadwalDokter::all();
    //     return view('admin.jadwal-dokters.index', ['jadwalDokters' => $jadwalDokters]);
    // }

    public function indexPending()
    {
        $jadwalDokters = JadwalDokter::where('status', 'Pending')->get();
        return view('admin.jadwal-dokters.index', ['jadwalDokters' => $jadwalDokters]);
    }

    public function review($id)
    {
        JadwalDokter::where('id_jadwal_dokter', $id)->update(['seen' => true]);
        $jadwalDokter = JadwalDokter::find($id);
        return view('admin.jadwal-dokters.review', ['jadwalDokter' => $jadwalDokter]);
    }

    public function reviewStore(Request $request, string $id)
    {
        $validateData = $request->validate([
            'status' => 'required|max:10'
        ]);

        JadwalDokter::where('id_jadwal_dokter', $id)->update($validateData);
        return redirect('/jadwal-dokter')->with('pesan', 'Data updated successfully');
    }
}
