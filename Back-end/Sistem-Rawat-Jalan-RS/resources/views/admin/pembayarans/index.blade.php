@extends('layouts.main')
@section('sidePembayaran', 'active')

@section('content')

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Pembayaran</h1>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Table Pembayaran</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead class="text-center">
                            <tr>
                                <th>Nota</th>
                                <th>Tanggal</th>
                                <th>Total Biaya</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        @foreach ($pembayarans as $pembayaran)
                            <tr>
                                <td>{{ $pembayaran->nota }}</td>
                                <td>{{ $pembayaran->tanggal_pembayaran }}</td>
                                <td>{{ $pembayaran->total_biaya }}</td>
                                <td class="text-center">
                                    <a href="{{ route('pembayaran.show', ['id' => $pembayaran->id_pembayaran]) }}"
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
