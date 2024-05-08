@extends('layouts.main')

@section('content')
    @if (session()->has('pesan'))
        <div class="alert alert-danger" role="alert">
            {{ session('pesan') }}
        </div>
    @endif

    <div class="col-lg-6 mb-5">
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Change Password</h1>
        </div>
        <form method="post" action="{{ route('users.change-password.store') }}">
            @csrf

            <div class="form-group mb-5">
                <label>New Password</label>
                <input type="password" placeholder="Password minimal 8 karakter"
                    class="form-control form-control-user @error('new_password') is-invalid @enderror" name="new_password"
                    value="{{ session('new_password') }}">
                @error('new_password')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="form-group mb-5">
                <label>Confirmation New Password</label>
                <input type="password" placeholder="Konfirmasi Password minimal 8 karakter"
                    class="form-control form-control-user @error('confirm_password') is-invalid @enderror"
                    name="confirm_password">
                @error('confirm_password')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <button type="submit" class="btn btn-primary">Save</button>
        </form>
    </div>
@endsection
