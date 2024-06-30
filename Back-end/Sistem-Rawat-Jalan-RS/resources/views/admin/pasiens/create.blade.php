@extends('layouts.main')
@section('sidePasien', 'active')

@section('content')
    <div class="col-lg-6 mb-5">
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Insert Pasien</h1>
        </div>
        <form method="post" action="{{ route('pasien.store', ['id' => $id]) }}">
            @csrf

            <div class="form-group mb-5">
                <label>Nama Pasien</label>
                <input type="text" class="form-control form-control-user @error('nama_pasien') is-invalid @enderror"
                    placeholder="Masukkan Nama Pasien" value="{{ old('nama_pasien') }}" name="nama_pasien">
                @error('nama_pasien')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="form-group mb-5">
                <label>No. BPJS</label>
                <input type="text" class="form-control form-control-user @error('no_bpjs') is-invalid @enderror"
                    placeholder="Masukkan 11 digit No. BPJS Pasien " value="{{ old('no_bpjs') }}" name="no_bpjs">
                @error('no_bpjs')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="form-group mb-5">
                <label>NIK</label>
                <input type="text" class="form-control form-control-user @error('nik') is-invalid @enderror"
                    placeholder="Masukkan 14 digit NIK Pasien " value="{{ old('nik') }}" name="nik">
                @error('nik')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="form-group mb-5">
                <label>Jenis Kelamin</label>
                @php
                    $jenisKelamins = ['Laki-Laki', 'Perempuan'];
                @endphp
                <select class="form-control form-control-user col-4 @error('jenis_kelamin') is-invalid @enderror"
                    name="jenis_kelamin">
                    <option value="" selected> -- Pilih -- </option>
                    @foreach ($jenisKelamins as $jenisKelamin)
                        <option value="{{ $jenisKelamin }}" @selected(old('jenis_kelamin') == $jenisKelamin)>{{ $jenisKelamin }}</option>
                    @endforeach
                </select>
                @error('jenis_kelamin')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="form-group mb-5">
                <label>Tempat Lahir</label>
                <input type="text" class="form-control form-control-user @error('tempat_lahir') is-invalid @enderror"
                    placeholder="Masukkan Tempat Lahir Pasien" value="{{ old('tempat_lahir') }}" name="tempat_lahir">
                @error('tempat_lahir')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="form-group mb-5">
                <label>Tanggal Lahir</label>
                <input type="date" class="form-control form-control-user @error('tanggal_lahir') is-invalid @enderror"
                    placeholder="Masukkan Tanggal Lahir Pasien" value="{{ old('tanggal_lahir') }}" name="tanggal_lahir">
                @error('tanggal_lahir')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="form-group mb-5">
                <label>No. HP</label>
                <input type="text" class="form-control form-control-user @error('no_hp') is-invalid @enderror"
                    placeholder="Masukkan Nomor HP Pasien" value="{{ old('no_hp') }}" name="no_hp">
                @error('no_hp')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="form-group">
                        <label class="form-control-label">Alamat</label>
                        <textarea class="form-control form-control-user @error('alamat') is-invalid @enderror"
                            placeholder="Masukkan Alamat Pasien" rows="3" name="alamat">{{ old('alamat') }}</textarea>
                        @error('alamat')
                            <div class="invalid-feedback">
                                {{ $message }}
                            </div>
                        @enderror
                    </div>
                </div>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
@endsection
