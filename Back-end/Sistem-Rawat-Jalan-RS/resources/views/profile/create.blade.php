@extends('layouts.main')

@section('content')
    <!-- Page Heading -->
    <h1 class="h3 mb-4 text-gray-800"></h1>

    <div class="row">

        <div class="col-lg-4 order-lg-2">

            <div class="card shadow mb-4">
                <div class="card-profile-image mt-4">
                    <figure class="rounded-circle avatar avatar font-weight-bold"
                        style="font-size: 60px; height: 180px; width: 180px;" data-initial=""></figure>
                </div>
                <div class="card-body">

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="text-center">
                                <h5 class="font-weight-bold"></h5>
                                @can('petugas-medis')
                                    <p>Petugas Medis</p>
                                @endcan
                                @can('apoteker')
                                    <p>Apoteker</p>
                                @endcan
                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </div>

        <div class="col-lg-8 order-lg-1">

            <div class="card shadow mb-4">

                <div class="card-header py-3">
                    @can('petugas-medis')
                        <h6 class="m-0 font-weight-bold text-primary">Profile Petugas Medis</h6>
                    @endcan
                    @can('apoteker')
                        <h6 class="m-0 font-weight-bold text-primary">Profile Apoteker</h6>
                    @endcan
                </div>

                <div class="card-body">

                    @can('petugas-medis')
                        <h6 class="heading-small text-muted mb-4">Petugas Medis information</h6>

                        <div class="pl-lg-4">
                            <form action="{{ route('profile.create') }}" method="post">
                                @csrf

                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <label class="form-control-label">Nama</label>
                                            <input type="text"
                                                class="form-control form-control-user @error('nama_petugas_medis') is-invalid @enderror"
                                                placeholder="Masukkan nama" value="{{ old('nama_petugas_medis') }}"
                                                name="nama_petugas_medis">
                                            @error('nama_petugas_medis')
                                                <div class="invalid-feedback">
                                                    {{ $message }}
                                                </div>
                                            @enderror
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <label class="form-control-label">Email</label>
                                            <input type="text" class="form-control" value="{{ $profile->email }}" readonly>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <label class="form-control-label">NIP</label>
                                            <input type="text"
                                                class="form-control form-control-user @error('nip') is-invalid @enderror"
                                                placeholder="Masukkan Nomor Induk Pegawai" value="{{ old('nip') }}"
                                                name="nip">
                                            @error('nip')
                                                <div class="invalid-feedback">
                                                    {{ $message }}
                                                </div>
                                            @enderror
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <label class="form-control-label">Jenis Kelamin</label>
                                            @php
                                                $jenisKelamins = ['Laki-Laki', 'Perempuan'];
                                            @endphp
                                            <select
                                                class="form-control form-control-user @error('jenis_kelamin') is-invalid @enderror"
                                                name="jenis_kelamin">
                                                <option value="" selected> -- Pilih -- </option>
                                                @foreach ($jenisKelamins as $jenisKelamin)
                                                    <option value="{{ $jenisKelamin }}" @selected(old('jenis_kelamin') == $jenisKelamin)>
                                                        {{ $jenisKelamin }}</option>
                                                @endforeach
                                            </select>
                                            @error('jenis_kelamin')
                                                <div class="invalid-feedback">
                                                    {{ $message }}
                                                </div>
                                            @enderror
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <label class="form-control-label">No. HP</label>
                                            <input type="text"
                                                class="form-control form-control-user @error('no_hp') is-invalid @enderror"
                                                placeholder="Masukkan Nomor HP" value="{{ old('no_hp') }}" name="no_hp">
                                            @error('no_hp')
                                                <div class="invalid-feedback">
                                                    {{ $message }}
                                                </div>
                                            @enderror
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <label class="form-control-label">Alamat</label>
                                            <textarea class="form-control form-control-user @error('alamat') is-invalid @enderror" placeholder="Masukkan Alamat"
                                                rows="3" placeholder="Masukkan alamat" name="alamat">{{ old('alamat') }}</textarea>
                                            @error('alamat')
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
                    @endcan

                    @can('apoteker')
                        <h6 class="heading-small text-muted mb-4">Apoteker information</h6>

                        <div class="pl-lg-4">
                            <form action="{{ route('profile.create') }}" method="post">
                                @csrf

                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <label class="form-control-label">Nama</label>
                                            <input type="text"
                                                class="form-control form-control-user @error('nama_apoteker') is-invalid @enderror"
                                                placeholder="Masukkan nama" value="{{ old('nama_apoteker') }}"
                                                name="nama_apoteker">
                                            @error('nama_apoteker')
                                                <div class="invalid-feedback">
                                                    {{ $message }}
                                                </div>
                                            @enderror
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <label class="form-control-label">Email</label>
                                            <input type="text" class="form-control" value="{{ $profile->email }}"
                                                readonly>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <label class="form-control-label">NO. SIPA</label>
                                            <input type="text"
                                                class="form-control form-control-user @error('no_sipa') is-invalid @enderror"
                                                placeholder="Masukkan Nomor Induk Pegawai" value="{{ old('no_sipa') }}"
                                                name="no_sipa">
                                            @error('no_sipa')
                                                <div class="invalid-feedback">
                                                    {{ $message }}
                                                </div>
                                            @enderror
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <label class="form-control-label">Jenis Kelamin</label>
                                            @php
                                                $jenisKelamins = ['Laki-Laki', 'Perempuan'];
                                            @endphp
                                            <select
                                                class="form-control form-control-user @error('jenis_kelamin') is-invalid @enderror"
                                                name="jenis_kelamin">
                                                <option value="" selected> -- Pilih -- </option>
                                                @foreach ($jenisKelamins as $jenisKelamin)
                                                    <option value="{{ $jenisKelamin }}" @selected(old('jenis_kelamin') == $jenisKelamin)>
                                                        {{ $jenisKelamin }}</option>
                                                @endforeach
                                            </select>
                                            @error('jenis_kelamin')
                                                <div class="invalid-feedback">
                                                    {{ $message }}
                                                </div>
                                            @enderror
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <label class="form-control-label">No. HP</label>
                                            <input type="text"
                                                class="form-control form-control-user @error('no_hp') is-invalid @enderror"
                                                placeholder="Masukkan Nomor HP" value="{{ old('no_hp') }}" name="no_hp">
                                            @error('no_hp')
                                                <div class="invalid-feedback">
                                                    {{ $message }}
                                                </div>
                                            @enderror
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <label class="form-control-label">Alamat</label>
                                            <textarea class="form-control form-control-user @error('alamat') is-invalid @enderror" placeholder="Masukkan Alamat"
                                                rows="3" name="alamat">{{ old('alamat') }}</textarea>
                                            @error('alamat')
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
                    @endcan

                </div>

            </div>

        </div>

    </div>
@endsection
