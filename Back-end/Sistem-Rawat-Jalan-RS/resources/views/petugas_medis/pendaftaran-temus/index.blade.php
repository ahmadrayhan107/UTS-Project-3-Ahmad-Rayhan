@extends('layouts.main')
@section('sidePendaftaranTemu', 'active')

@section('content')

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Pendaftaran Temu</h1>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Table Pendaftaran Temu</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead class="text-center">
                            <tr>
                                <th>Nama Pasien</th>
                                <th>Nama Dokter</th>
                                <th>Tanggal Pendaftaran</th>
                                <th>Jam</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        @foreach ($pendaftaranTemus as $pendaftaranTemu)
                            <tr>
                                <td>{{ $pendaftaranTemu->pasien->nama_pasien }}</td>
                                <td>{{ $pendaftaranTemu->dokter->nama_dokter }}</td>
                                <td>{{ \Carbon\Carbon::parse($pendaftaranTemu->tanggal_pendaftaran)->translatedFormat('d F Y') }}</td>
                                <td>{{ \Carbon\Carbon::parse($pendaftaranTemu->jam)->translatedFormat('H:i') }}</td>
                                @if ($pendaftaranTemu->status === 'Pending')
                                    <td class="align-center text-warning">{{ $pendaftaranTemu->status }}</td>
                                @elseif ($pendaftaranTemu->status === 'Selesai')
                                    <td class="align-center text-success">{{ $pendaftaranTemu->status }}</td>
                                @else
                                    <td class="align-center text-info">{{ $pendaftaranTemu->status }}</td>
                                @endif
                            </tr>
                        @endforeach
                    </table>
                </div>
            </div>
        </div>

    </div>
    <!-- /.container-fluid -->

@endsection
