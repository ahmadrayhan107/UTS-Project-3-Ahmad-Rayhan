<?php

namespace App\Http\Controllers;

use App\Models\PendaftaranTemu;
use Illuminate\Http\Request;

class PendaftaranTemuController extends Controller
{
    public function index()
    {
        $pendaftaranTemus = PendaftaranTemu::all();
        return view('petugas_medis.pendaftaran-temus.index', ['pendaftaranTemus' => $pendaftaranTemus]);
    }
}
