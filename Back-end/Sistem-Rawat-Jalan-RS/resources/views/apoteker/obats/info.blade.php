@extends('layouts.main')
@section('sideDashboard', 'active')

@section('content')

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Resep Obat</h1>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Table Resep Obat</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" class="display" width="100%" cellspacing="0">
                        <thead class="text-center">
                            <tr>
                                <th>Nama Obat</th>
                                <th>Harga Obat</th>
                            </tr>
                        </thead>
                        <tbody>
                            @foreach ($daftarObats[0]->resepObat as $daftarObat)
                                <tr>
                                    <td>{{ $daftarObat->obat->nama_obat }}</td>
                                    <td>{{ $daftarObat->obat->harga_obat }}</td>
                                </tr>
                            @endforeach
                        </tbody>
                    </table>
                </div>

            </div>
        </div>

    </div>
    <!-- /.container-fluid -->

@endsection
