<?php

namespace App\Http\Controllers;

use App\Models\Apoteker;
use App\Models\PetugasMedis;
use App\Models\User;
use Illuminate\Http\Request;

class ProfileController extends Controller
{
    public function index()
    {
        $id = Auth()->user()->id_user;
        $profile = User::find($id);
        if ($profile->role === 'Petugas Medis') {
            $petugasMedis = PetugasMedis::where('user_id', $id)->first();
            if (!$petugasMedis) {
                return view('profile.create', ['profile' => $profile]);
            }
            return view('profile.edit', ['profile' => $profile, 'petugasMedis' => $petugasMedis]);
        } elseif ($profile->role === 'Apoteker') {
            $apoteker = Apoteker::where('user_id', $id)->first();
            if (!$apoteker) {
                return view('profile.create', ['profile' => $profile]);
            }
            return view('profile.edit', ['profile' => $profile, 'apoteker' => $apoteker]);
        }
    }

    public function store(Request $request)
    {
        if (Auth()->user()->role === 'Petugas Medis') {
            $validateData = $request->validate([
                'nama_petugas_medis' => 'required|max:30',
                'nip' => 'required|size:18|unique:petugas_medis,nip',
                'jenis_kelamin' => 'required|max:10',
                'no_hp' => 'required|digits_between:10,15|numeric|unique:petugas_medis,nip',
                'alamat' => 'required|max:50'
            ]);

            $user_id = Auth()->user()->id_user;

            if ($request->img_profile) {
                $request->validate([
                    'img_profile' => '  image|mimes:png,jpg',
                ]);
                $namaFile = '/img/profiles/img_' . time() . '_' . $request->img_profile->getClientOriginalName();
                $request->img_profile->move('img/profiles', $namaFile);
                User::where('id_user', $user_id)->update(['img_profile' => $namaFile]);
            }

            $validateData['user_id'] = $user_id;

            PetugasMedis::create($validateData);
            return redirect('/profile')->with('pesan', 'Data saved successfully');
        } elseif (Auth()->user()->role === 'Apoteker') {
            $validateData = $request->validate([
                'nama_apoteker' => 'required|max:30',
                'no_sipa' => 'required|size:18|unique:apotekers,no_sipa',
                'jenis_kelamin' => 'required|max:10',
                'no_hp' => 'required|digits_between:10,15|numeric|unique:apotekers,no_sipa',
                'alamat' => 'required|max:50'
            ]);

            $user_id = Auth()->user()->id_user;

            if ($request->img_profile) {
                $request->validate([
                    'img_profile' => '  image|mimes:png,jpg',
                ]);
                $namaFile = '/img/profiles/img_' . time() . '_' . $request->img_profile->getClientOriginalName();
                $request->img_profile->move('img/profiles', $namaFile);
                User::where('id_user', $user_id)->update(['img_profile' => $namaFile]);
            }

            $validateData['user_id'] = $user_id;

            Apoteker::create($validateData);
            return redirect('/profile')->with('pesan', 'Data saved successfully');
        }
    }

    public function update(Request $request, string $id)
    {
        if (Auth()->user()->role === 'Petugas Medis') {
            $validateData = $request->validate([
                'nama_petugas_medis' => 'required|max:30',
                'nip' => 'required|size:18|unique:petugas_medis,nip,' . $id . ',id_petugas_medis',
                'jenis_kelamin' => 'required|max:10',
                'no_hp' => 'required|digits_between:10,15|numeric',
                'alamat' => 'required|max:50'
            ]);

            if ($request->img_profile) {
                $request->validate([
                    'img_profile' => '  image|mimes:png,jpg',
                ]);
                $namaFile = '/img/profiles/img_' . time() . '_' . $request->img_profile->getClientOriginalName();
                $request->img_profile->move('img/profiles', $namaFile);
                $id_user = Auth()->user()->id_user;
                User::where('id_user', $id_user)->update(['img_profile' => $namaFile]);
            }

            PetugasMedis::where('id_petugas_medis', $id)->update($validateData);
            return redirect('/profile')->with('pesan', 'Data updated successfully');
        } elseif (Auth()->user()->role === 'Apoteker') {
            $validateData = $request->validate([
                'nama_apoteker' => 'required|max:30',
                'no_sipa' => 'required|size:18|unique:apotekers,no_sipa,' .  $id . ',id_apoteker',
                'jenis_kelamin' => 'required|max:10',
                'no_hp' => 'required|digits_between:10,15|numeric|unique:apotekers,no_sipa,' . $id . ',id_apoteker',
                'alamat' => 'required|max:50'
            ]);

            if ($request->img_profile) {
                $request->validate([
                    'img_profile' => '  image|mimes:png,jpg',
                ]);
                $namaFile = '/img/profiles/img_' . time() . '_' . $request->img_profile->getClientOriginalName();
                $request->img_profile->move('img/profiles', $namaFile);
                $id_user = Auth()->user()->id_user;
                User::where('id_user', $id_user)->update(['img_profile' => $namaFile]);
            }

            Apoteker::where('id_apoteker', $id)->update($validateData);
            return redirect('/profile')->with('pesan', 'Data updated successfully');
        }
    }
}
