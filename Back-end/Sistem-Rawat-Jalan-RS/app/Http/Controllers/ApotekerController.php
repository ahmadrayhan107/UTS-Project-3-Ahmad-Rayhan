<?php

namespace App\Http\Controllers;

use App\Models\Apoteker;
use Illuminate\Http\Request;

class ApotekerController extends Controller
{
    public function index()
    {
        $apotekers = Apoteker::all();
        return view('admin.apotekers.index', ['apotekers' => $apotekers]);
    }

    public function show($id)
    {
        $apoteker = Apoteker::find($id); 
        $userApoteker = Apoteker::find($id)->user;
        return view('admin.apotekers.show', ['apoteker' => $apoteker, 'userApoteker' => $userApoteker]);
    }
}
