@extends('layouts.main')
@section('sideJadwalDokter', 'active')

@section('content')
    <!-- Page Heading -->
    <h1 class="h3 mb-4 text-gray-800"></h1>

    <div class="row">

        <div class="col-lg-8 order-lg-1">

            <div class="card shadow mb-4">

                <div class="card-body">

                    <h6 class="heading-small text-muted mb-4">Permintaan Jadwal Dokter</h6>

                    <div class="pl-lg-4">

                        <div class="row">
                            <div class="col-lg-12">
                                Kepada Admin,<br>
                                <b>{{ $jadwalDokter->dokter->nama_dokter }}</b> ingin melakukan permintaan jadwal praktek
                                pada hari
                                {{ $jadwalDokter->hari }}, tanggal
                                {{ \Carbon\Carbon::parse($jadwalDokter->tanggal_praktek)->translatedFormat('d F Y') }}. Jam
                                {{ \Carbon\Carbon::parse($jadwalDokter->jam_awal)->translatedFormat('H:i') . '-' . \Carbon\Carbon::parse($jadwalDokter->jam_akhir)->translatedFormat('H:i') }}.
                                <br>
                                Apakah permintaan berikut akan diterima?
                            </div>
                        </div>

                        <form action="{{ route('jadwal-dokter.review.store', ['id' => $jadwalDokter->id_jadwal_dokter]) }}" method="post">
                            @method('PUT')
                            @csrf

                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        @php
                                            $reviews = ['Accepted', 'Canceled'];
                                        @endphp
                                        @foreach ($reviews as $review)
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" value="{{ $review }}"
                                                    name="status" @checked(old('status') == $review) checked>
                                                <label class="form-check-label">{{ $review }}</label>
                                            </div>
                                        @endforeach
                                        @error('status')
                                            <div class="invalid-feedback">
                                                {{ $message }}
                                            </div>
                                        @enderror
                                    </div>
                                </div>
                            </div>

                            <button type="submit" class="btn btn-primary">Save</button>
                        </form>


                    </div>

                </div>

            </div>

        </div>

    </div>
@endsection
