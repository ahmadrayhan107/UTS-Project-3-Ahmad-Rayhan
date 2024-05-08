@extends('layouts.main')
@section('sideApoteker', 'active')

@section('content')

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Apoteker</h1>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Table Apoteker</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead class="text-center">
                            <tr>
                                <th>Nama apoteker</th>
                                <th>No. SIPA</th>
                                <th>Jenis Kelamin</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        @foreach ($apotekers as $apoteker)
                            <tr>
                                <td>{{ $apoteker->nama_apoteker }}</td>
                                <td>{{ $apoteker->no_sipa }}</td>
                                <td>{{ $apoteker->jenis_kelamin }}</td>
                                <td class="text-center">
                                    <a href="{{ route('apoteker.show', ['id' => $apoteker->id_apoteker]) }}"
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
