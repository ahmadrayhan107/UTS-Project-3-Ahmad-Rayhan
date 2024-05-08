@extends('layouts.main')
@section('sideUser', 'active')

@section('content')
    <div class="col-lg-6 mb-5">
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Insert User</h1>
        </div>
        <form method="post" action="{{ route('users.store') }}">
            @csrf

            <div class="form-group mb-5">
                <label>Username</label>
                <input type="text" class="form-control form-control-user @error('username') is-invalid @enderror"
                    placeholder="Masukkan username" value="{{ old('username') }}" name="username">
                @error('username')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="form-group mb-5">
                <label>Email</label>
                <input type="email" class="form-control form-control-user @error('email') is-invalid @enderror"
                    placeholder="example@email.com" value="{{ old('email') }}" name="email">
                @error('email')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="form-group mb-5">
                <label>Password</label>
                <input type="password" placeholder="Password minimal 8 karakter"
                    class="form-control form-control-user @error('password') is-invalid @enderror" name="password">
                @error('password')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="form-group">
                <label>Role</label>
                @php
                    $roles = ['Pasien', 'Dokter', 'Petugas Medis', 'Apoteker'];
                @endphp
                <select class="form-control form-control-user col-4 @error('role') is-invalid @enderror" name="role">
                    <option value="" selected> -- Pilih -- </option>
                    @foreach ($roles as $role)
                        <option value="{{ $role }}" @selected(old('role') == $role)>{{ $role }}</option>
                    @endforeach
                </select>
                @error('role')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
@endsection
