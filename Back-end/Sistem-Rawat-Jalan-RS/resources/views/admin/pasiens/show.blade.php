@extends('layouts.main')
@section('sidePasien', 'active')

@section('content')
    <!-- Page Heading -->
    <h1 class="h3 mb-4 text-gray-800"></h1>

    <div class="row">

        <div class="col-lg-4 order-lg-2">

            <div class="card shadow mb-4">
                <div class="card-profile-image mt-4">
                    @php
                        $img = $pasien->user->img_profile ? $pasien->user->img_profile : 'img/undraw_profile.svg';
                    @endphp
                    <img src="{{ asset($img) }}" class="img-fluid rounded-circle">
                </div>
                <div class="card-body">

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="text-center">
                                <h5 class="font-weight-bold"></h5>
                                <p>Pasien</p>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </div>

        <div class="col-lg-8 order-lg-1">

            <div class="card shadow mb-4">

                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Data Pasien</h6>
                </div>

                <div class="card-body">

                    <h6 class="heading-small text-muted mb-4">Pasien information</h6>

                    <div class="pl-lg-4">

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-2 form-control-label">Nama Pasien</label>
                                    <label class="col-sm-10">{{ $pasien->nama_pasien }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-2 form-control-label">Email</label>
                                    <label class="col-sm-10">{{ $pasien->user->email }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 form-control-label">No. BPJS</label>
                            <label class="col-sm-10">{{ $pasien->no_bpjs }}</label>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 form-control-label">NIK</label>
                            <label class="col-sm-10">{{ $pasien->nik }}</label>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-2 form-control-label">Jenis Kelamin</label>
                                    <label class="col-sm-10">{{ $pasien->jenis_kelamin }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-2 form-control-label">Tempat Lahir</label>
                                    <label class="col-sm-10">{{ $pasien->tempat_lahir }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-2 form-control-label">Tanggal Lahir</label>
                                    <label
                                        class="col-sm-10">{{ \Carbon\Carbon::parse($pasien->tanggal_lahir)->translatedFormat('d F Y') }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-2 form-control-label">No. HP</label>
                                    <label class="col-sm-10">{{ $pasien->no_hp }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <div class="form-group row">
                                        <label class="col-sm-2 form-control-label">Alamat</label>
                                        <label class="col-sm-10">{{ $pasien->alamat }}</label>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>

            </div>

            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead class="text-center">
                            <tr>
                                <th>Kode Rekam Medis</th>
                                <th>Tanggal Periksa</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        @foreach ($pasien->rekamMedis as $rekamMedis)
                            <tr>
                                <td>{{ $rekamMedis->kode_rekam_medis }}</td>
                                <td>{{ $rekamMedis->tanggal_periksa }}</td>
                                <td class="text-center">
                                    <a href="{{ route('rekam-medis.show', ['id' => $rekamMedis->id_rekam_medis]) }}"
                                        class="btn btn-info btn-circle">
                                        <i class="fas fa-fw fa-info"></i>
                                    </a>
                                </td>
                            </tr>
                        @endforeach
                    </table>
                </div>
            </div>

        </div>

    </div>
@endsection
