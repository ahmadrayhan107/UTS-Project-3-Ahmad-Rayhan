<?php

namespace App\Http\Controllers;

use App\Models\Pembayaran;

class PembayaranController extends Controller
{
    public function index()
    {
        $pembayarans = Pembayaran::all();
        return view('admin.pembayarans.index', ['pembayarans' => $pembayarans]);
    }

    public function show($id) {
        $pembayaran = Pembayaran::find($id);
        return view('admin.pembayarans.show', ['pembayaran' => $pembayaran]);
    }
}
