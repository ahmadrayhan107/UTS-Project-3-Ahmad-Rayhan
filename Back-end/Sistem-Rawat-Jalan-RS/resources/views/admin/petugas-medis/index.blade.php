@extends('layouts.main')
@section('sidePetugasMedis', 'active')

@section('content')

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Petugas Medis</h1>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Table Petugas Medis</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead class="text-center">
                            <tr>
                                <th>Nama Petugas Medis</th>
                                <th>NIP</th>
                                <th>Jenis Kelamin</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        @foreach ($petugasMedises as $petugasMedis)
                            <tr>
                                <td>{{ $petugasMedis->nama_petugas_medis }}</td>
                                <td>{{ $petugasMedis->nip }}</td>
                                <td>{{ $petugasMedis->jenis_kelamin }}</td>
                                <td class="text-center">
                                    <a href="{{ route('petugas-medis.show', ['id' => $petugasMedis->id_petugas_medis]) }}"
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
