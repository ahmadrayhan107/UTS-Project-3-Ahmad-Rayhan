@extends('layouts.main')
@section('sideObat', 'active')

@section('content')
    <div class="col-lg-6 mb-5">
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Insert Obat</h1>
        </div>
        <form method="post" action="{{ route('obat.store') }}">
            @csrf

            <div class="form-group mb-5">
                <label>Nama Obat</label>
                <input type="text" class="form-control form-control-user @error('nama_obat') is-invalid @enderror"
                    placeholder="Masukkan nama obat" value="{{ old('nama_obat') }}" name="nama_obat">
                @error('nama_obat')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="form-group mb-5">
                <label>Harga Obat</label>
                <input type="number" class="form-control form-control-user @error('harga_obat') is-invalid @enderror"
                    placeholder="Masukkan harga obat" value="{{ old('harga_obat') }}" name="harga_obat">
                @error('harga_obat')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <div class="form-group">
                <label>Status</label>
                @php
                    $statuses = ['Tersedia', 'Habis', 'Dipesan'];
                @endphp
                <select class="form-control form-control-user col-4 @error('status') is-invalid @enderror" name="status">
                    <option value="" selected> -- Pilih -- </option>
                    @foreach ($statuses as $status)
                        <option value="{{ $status }}" @selected(old('status') == $status)>{{ $status }}</option>
                    @endforeach
                </select>
                @error('status')
                    <div class="invalid-feedback">
                        {{ $message }}
                    </div>
                @enderror
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
@endsection
