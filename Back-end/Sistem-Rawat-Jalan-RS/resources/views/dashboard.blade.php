@extends('layouts.main')
@section('sideDashboard', 'active')

@section('content')
    <!-- Begin Page Content -->
    <div class="container-fluid">

        @if (session()->has('pesan'))
            <div class="alert alert-success" role="alert">
                {{ session('pesan') }}
            </div>
        @endif

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Welcome, <b>{{ Auth()->user()->role }}</b></h1>

        <div class="row">

            @can('admin')
                @section('title', 'SISRAWAT-Admin')
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-primary shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                        Total Users
                                    </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">{{ $countUsers }}</div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-primary shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                        Total Pasien
                                    </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">{{ $countPasien }}</div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-primary shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                        Total Dokter
                                    </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">{{ $countDokter }}</div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-primary shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                        Total Petugas Medis
                                    </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">{{ $countPetugasMedis }}</div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-primary shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                        Total Apoteker
                                    </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">{{ $countApoteker }}</div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-primary shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                        Total Jadwal Dokter
                                    </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">{{ $countJadwalDokter }}</div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-warning shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                        Total Pending Jadwal Dokter
                                    </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">{{ $countPendingJadwalDokter }}</div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-success shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                        Total Accepted Jadwal Dokter
                                    </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">{{ $countAcceptedJadwalDokter }}</div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-danger shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-danger text-uppercase mb-1">
                                        Total Canceled Jadwal Dokter
                                    </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">{{ $countCanceledJadwalDokter }}</div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-info shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-info text-uppercase mb-1">
                                        Total Penghasilan
                                    </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">{{ 'Rp' . $totalPenghasilan }}</div>
                                </div>
                                <div class="col-auto">
                                    <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            @endcan

            @can('petugas-medis')

                @section('title', 'SISRAWAT-Petugas Medis')
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Table Daftar Antrian</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" class="display" width="100%"
                                    cellspacing="0">
                                    <thead class="text-center">
                                        <tr>
                                            <th>No. Pendaftaran</th>
                                            <th>Jam</th>
                                            <th>Nama Pasien</th>
                                            <th>Nama Dokter</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        @foreach ($pendaftaranTemus as $pendaftaranTemu)
                                            <tr>
                                                <td>{{ $pendaftaranTemu->no_pendaftaran }}</td>
                                                <td>{{ $pendaftaranTemu->jam }}</td>
                                                <td>{{ $pendaftaranTemu->pasien->nama_pasien }}</td>
                                                <td>{{ $pendaftaranTemu->dokter->nama_dokter }}</td>
                                                </td>
                                                <td class="text-center">
                                                    <a href="{{ route('rekam-medis.create', ['id' => $pendaftaranTemu->id_pendaftaran_temu]) }}"
                                                        class="btn btn-warning btn-circle">
                                                        <i class="fas fa-fw fa-arrow-right"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        @endforeach
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            @endcan

            @can('apoteker')

                @section('title', 'SISRAWAT-Apoteker')
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Table Daftar Antrian</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" class="display" width="100%"
                                    cellspacing="0">
                                    <thead class="text-center">
                                        <tr>
                                            <th>No. Pendaftaran</th>
                                            <th>Nama Pasien</th>
                                            <th>Nama Dokter</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        @foreach ($pendaftaranTemus as $pendaftaranTemu)
                                            <tr>
                                                <td>{{ $pendaftaranTemu->no_pendaftaran }}</td>
                                                <td>{{ $pendaftaranTemu->pasien->nama_pasien }}</td>
                                                <td>{{ $pendaftaranTemu->dokter->nama_dokter }}</td>
                                                </td>
                                                <td class="text-center">
                                                    <a href="" class="btn btn-info btn-circle">
                                                        <i class="fas fa-fw fa-info"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        @endforeach
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            @endcan

        </div>

    </div>
    <!-- /.container-fluid -->
@endsection
