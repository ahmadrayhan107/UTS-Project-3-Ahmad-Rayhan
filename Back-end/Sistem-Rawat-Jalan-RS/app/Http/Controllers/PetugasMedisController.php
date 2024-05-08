<?php

namespace App\Http\Controllers;

use App\Models\PetugasMedis;
use Illuminate\Http\Request;

class PetugasMedisController extends Controller
{
    public function index()
    {
        $petugasMedises = PetugasMedis::all();
        return view('admin.petugas-medis.index', ['petugasMedises' => $petugasMedises]);
    }

    public function show($id)
    {
        $petugasMedis = PetugasMedis::find($id);
        $userPetugasMedis = PetugasMedis::find($id)->user;
        return view('admin.petugas-medis.show', ['petugasMedis' => $petugasMedis, 'userPetugasMedis' => $userPetugasMedis]);
    }
}
