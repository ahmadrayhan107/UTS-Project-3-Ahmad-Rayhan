@extends('layouts.main')
@section('sidePetugasMedis', 'active')

@section('content')
    <!-- Page Heading -->
    <h1 class="h3 mb-4 text-gray-800"></h1>

    <div class="row">

        <div class="col-lg-4 order-lg-2">

            <div class="card shadow mb-4">
                <div class="card-profile-image mt-4">
                    @php
                        $img = $petugasMedis->user->img_profile ? $petugasMedis->user->img_profile : 'img/undraw_profile.svg';
                    @endphp
                    <img src="{{ asset($img) }}" class="img-fluid rounded-circle">
                </div>
                <div class="card-body">

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="text-center">
                                <h5 class="font-weight-bold"></h5>
                                <p>Petugas Medis</p>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </div>

        <div class="col-lg-8 order-lg-1">

            <div class="card shadow mb-4">

                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Data Petugas Medis</h6>
                </div>

                <div class="card-body">

                    <h6 class="heading-small text-muted mb-4">Petugas Medis information</h6>

                    <div class="pl-lg-4">

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-2 form-control-label">Nama Petugas Medis</label>
                                    <label class="col-sm-10">{{ $petugasMedis->nama_petugas_medis }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-2 form-control-label">Email</label>
                                    <label class="col-sm-10">{{ $userPetugasMedis->email }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-2 form-control-label">NIP</label>
                                    <label class="col-sm-10">{{ $petugasMedis->nip }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group row">
                                    <label class="col-sm-2 form-control-label">No. HP</label>
                                    <label class="col-sm-10">{{ $petugasMedis->no_hp }}</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <div class="form-group row">
                                        <label class="col-sm-2 form-control-label">Alamat</label>
                                        <label class="col-sm-10">{{ $petugasMedis->alamat }}</label>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>

            </div>

        </div>

    </div>
@endsection
