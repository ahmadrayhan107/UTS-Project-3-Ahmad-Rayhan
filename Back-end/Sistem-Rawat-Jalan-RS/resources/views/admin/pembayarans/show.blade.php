@extends('layouts.main')
@section('sidePembayaran', 'active')

@section('content')
    <!-- Page Heading -->
    <h1 class="h3 mb-4 text-gray-800"></h1>

    <div class="row">

        <div class="col-lg-10 order-lg-1">

            <div class="card shadow mb-4">

                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Data Pembayaran</h6>
                </div>

                <div class="card-body">

                    <h6 class="heading-small text-muted mb-4">Pembayaran information</h6>

                    <div class="pl-lg-4">

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-2 form-control-label">Nota</label>
                                    <label class="col-sm-10">{{ $pembayaran->nota }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-2 form-control-label">Tanggal Pembayaran</label>
                                    <label
                                        class="col-sm-10">{{ \Carbon\Carbon::parse($pembayaran->tanggal_pembayaran)->translatedFormat('d F Y') }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 form-control-label">Total Biaya</label>
                            <label class="col-sm-10">{{ $pembayaran->total_biaya }}</label>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-2 form-control-label">Nama Pasien</label>
                                    <label class="col-sm-10">{{ $pembayaran->pasien->nama_pasien }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-2 form-control-label">Status</label>
                                    <label class="col-sm-10">{{ $pembayaran->status }}</label>
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
                                <th>Nama Tagihan</th>
                                <th>Biaya</th>
                            </tr>
                        </thead>
                        @foreach ($pembayaran->detail as $detail)
                            <tr>
                                <td>{{ $detail->nama_tagihan }}</td>
                                <td>{{ $detail->biaya }}</td>
                            </tr>
                        @endforeach
                    </table>
                </div>
            </div>

        </div>

    </div>
@endsection
