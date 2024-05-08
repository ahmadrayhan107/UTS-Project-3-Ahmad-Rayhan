<?php

namespace App\Http\Controllers;

use App\Models\Dokter;
use Illuminate\Http\Request;

class DokterController extends Controller
{
    public function index() {
        $dokters = Dokter::all();
        return view('admin.dokters.index', ['dokters' => $dokters]);
    }

    public function show($id)
    {
        $dokter = Dokter::find($id);
        $userdokter = Dokter::find($id)->user;
        return view('admin.dokters.show', ['dokter' => $dokter, 'userdokter' => $userdokter]);
    }
}
