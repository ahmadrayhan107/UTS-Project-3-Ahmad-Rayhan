@extends('layouts.main')
@section('sideDokter', 'active')

@section('content')

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Dokter</h1>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Table Dokter</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead class="text-center">
                            <tr>
                                <th>Nama Dokter</th>
                                <th>NIP</th>
                                <th>Jenis Kelamin</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        @foreach ($dokters as $dokter)
                            <tr>
                                <td>{{ $dokter->nama_dokter }}</td>
                                <td>{{ $dokter->nip }}</td>
                                <td>{{ $dokter->jenis_kelamin }}</td>
                                <td class="text-center">
                                    <a href="{{ route('dokter.show', ['id' => $dokter->id_dokter]) }}"
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
