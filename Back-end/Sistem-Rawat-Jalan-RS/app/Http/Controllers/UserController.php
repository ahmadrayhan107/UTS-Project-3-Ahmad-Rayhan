<?php

namespace App\Http\Controllers;

use App\Models\Apoteker;
use App\Models\Dokter;
use App\Models\Pasien;
use App\Models\PetugasMedis;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;

class UserController extends Controller
{
    public function index()
    {
        $users = User::where('role', '!=', 'Admin')->get();
        return view('admin.users.index', ['users' => $users]);
    }

    public function create()
    {
        return view('admin.users.create');
    }

    public function store(Request $request)
    {
        $validateData = $request->validate([
            'username' => 'required|max:30',
            'email' => 'required|email|max:30|unique:users,email',
            'password' => 'required|min:8',
            'role' => 'required|filled|max:15'
        ]);

        $validateData['password'] = Hash::make($request->password);

        User::create($validateData);

        if ($validateData['role'] === 'Pasien') {
            $user = User::where('email', $validateData['email'])->first();
            return redirect(route('pasien.create', ['id' => $user->id_user]));
        } else {
            return redirect('/users')->with('pesan', 'Data saved successfully');
        }
    }

    public function destroy(string $id)
    {
        $user = User::find($id);

        if ($user->role === 'Pasien') {
            Pasien::where('user_id', $id)->delete();
        } elseif ($user->role === 'Dokter') {
            Dokter::where('user_id', $id)->delete();
        } elseif ($user->role === 'Petugas Medis') {
            PetugasMedis::where('user_id', $id)->delete();
        } elseif ($user->role === 'Apoteker') {
            Apoteker::where('user_id', $id)->delete();
        }

        User::where('id_user', $id)->delete();
        return redirect('/users')->with('pesan', 'Data deleted successfully');
    }

    public function changePassword()
    {
        return view('admin.users.change-password');
    }

    public function changePasswordStore(Request $request)
    {
        $validateData = $request->validate([
            'new_password' => 'required|min:8',
            'confirm_password' => 'required|min:8'
        ]);

        if ($validateData['new_password'] !== $validateData['confirm_password']) {
            return redirect('/users/change-password')
                ->with('pesan', 'Confirmation Password are not same')
                ->with('new_password', $request->new_password);
        }

        $password = Hash::make($request->new_password);

        $id_user = Auth()->user()->id_user;
        User::where('id_user', $id_user)->update(['password' => $password]);

        return redirect('/dashboard')->with('pesan', 'Password successfully changed');
    }
}
