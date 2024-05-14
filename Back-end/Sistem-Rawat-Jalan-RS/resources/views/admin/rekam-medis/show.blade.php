@extends('layouts.main')
@section('sidePasien', 'active')

@section('content')
    <!-- Page Heading -->
    <h1 class="h3 mb-4 text-gray-800"></h1>

    <div class="row">

        <div class="col-lg-10 order-lg-1">

            <div class="card shadow mb-4">

                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Data Rekam Medis</h6>
                </div>

                <div class="card-body">

                    <h6 class="heading-small text-muted mb-4">Rekam Medis information</h6>

                    <div class="pl-lg-4">

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Kode Rekam Medis</label>
                                    <label class="col-sm-9">{{ $rekamMedis->kode_rekam_medis }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Tanggal Periksa</label>
                                    <label
                                        class="col-sm-9">{{ \Carbon\Carbon::parse($rekamMedis->tanggal_periksa)->translatedFormat('d F Y') }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 form-control-label">Keluhan</label>
                            <label class="col-sm-9">{{ $rekamMedis->keluhan }}</label>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Diagnosa</label>
                                    <label class="col-sm-9">{{ $rekamMedis->diagnosa }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Tekanan Darah</label>
                                    <label class="col-sm-9">{{ $rekamMedis->tekanan_darah }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Suhu Tubuh</label>
                                    <label class="col-sm-9">{{ $rekamMedis->suhu_tubuh }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Berat Badan</label>
                                    <label class="col-sm-9">{{ $rekamMedis->berat_badan }}</label>
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
                                <th>Nama Obat</th>
                                <th>Dosis</th>
                                <th>Jenis Obat</th>
                                <th>Keterangan</th>
                            </tr>
                        </thead>
                        @foreach ($rekamMedis->resepObat as $resepObat)
                            <tr>
                                <td>{{ $resepObat->obat->nama_obat }}</td>
                                <td>{{ $resepObat->dosis }}</td>
                                <td>{{ $resepObat->jenis_obat }}</td>
                                <td>{{ $resepObat->keterangan }}</td>
                            </tr>
                        @endforeach
                    </table>
                </div>
            </div>

        </div>

    </div>
@endsection
