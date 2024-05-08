@extends('layouts.main')

@section('content')
    <div class="col-lg-6 mb-5">
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Insert Rekam Medis</h1>
        </div>
        <form method="post" action="{{ route('rekam-medis.store', ['pendaftaranTemu' => $pendaftaranTemu]) }}">
            @csrf

            <div class="row">
                <div class="col-lg-12">
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label">Nama Pasien</label>
                        <label class="col-sm-7">{{ $pendaftaranTemu->pasien->nama_pasien }}</label>
                    </div>
                </div>
            </div>

            <div class="row mb-3 border-bottom">
                <div class="col-lg-12">
                    <div class="form-group row">
                        <label class="col-sm-3 form-control-label">Nama Dokter</label>
                        <label class="col-sm-7">{{ $pendaftaranTemu->dokter->nama_dokter }}</label>
                    </div>
                </div>
            </div>

            <div class="form-group mb-5">
                <label>Tanggal Periksa</label>
                <input type="date" class="form-control form-control-user @error('tanggal_periksa') is-invalid @enderror"
                    value="{{ old('tanggal_periksa') }}" name="tanggal_periksa">
                @error('tanggal_periksa')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="form-group mb-5">
                <label>Keluhan</label>
                <input type="text" class="form-control form-control-user @error('keluhan') is-invalid @enderror"
                    placeholder="Keluhan Pasien" value="{{ old('keluhan') }}" name="keluhan">
                @error('keluhan')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="form-group mb-5">
                <label>Diagnosa</label>
                <input type="text" class="form-control form-control-user @error('diagnosa') is-invalid @enderror"
                    placeholder="Diagnosa Pasien" value="{{ old('diagnosa') }}" name="diagnosa">
                @error('diagnosa')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="form-group mb-5">
                <label>Tekanan Darah</label>
                <input type="number" class="form-control form-control-user @error('tekanan_darah') is-invalid @enderror"
                    placeholder="Tekanan Darah Pasien" value="{{ old('tekanan_darah') }}" name="tekanan_darah">
                @error('tekanan_darah')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="form-group mb-5">
                <label>Suhu Tubuh</label>
                <input type="number" class="form-control form-control-user @error('suhu_tubuh') is-invalid @enderror"
                    placeholder="Suhu Tubuh Pasien" value="{{ old('suhu_tubuh') }}" name="suhu_tubuh">
                @error('suhu_tubuh')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="form-group mb-5">
                <label>Berat Badan</label>
                <input type="number" class="form-control form-control-user @error('berat_badan') is-invalid @enderror"
                    placeholder="Berat Badan Pasien" value="{{ old('berat_badan') }}" name="berat_badan">
                @error('berat_badan')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
@endsection
