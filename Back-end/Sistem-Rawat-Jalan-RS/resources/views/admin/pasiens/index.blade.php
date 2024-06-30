@extends('layouts.main')
@section('sidePasien', 'active')

@section('content')

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Pasien</h1>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Table Pasien</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead class="text-center">
                            <tr>
                                <th>Nama Pasien</th>
                                <th>NO BPJS</th>
                                <th>NIK</th>
                                <th>Jenis Kelamin</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        @foreach ($pasiens as $pasien)
                            <tr>
                                <td>{{ $pasien->nama_pasien }}</td>
                                <td>{{ $pasien->no_bpjs }}</td>
                                <td>{{ $pasien->nik }}</td>
                                <td>{{ $pasien->jenis_kelamin }}</td>
                                <td class="text-center">
                                    <a href="{{ route('pasien.show', ['id' => $pasien->id_pasien]) }}"
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
    <!-- /.container-fluid -->

@endsection
