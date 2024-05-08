@extends('layouts.main')
@section('sideJadwalDokter', 'active')

@section('content')

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Jadwal Dokter</h1>

        @if (session()->has('pesan'))
            <div class="alert alert-success" role="alert">
                {{ session('pesan') }}
            </div>
        @endif

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Table Jadwal Dokter</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead class="text-center">
                            <tr>
                                <th>Nama Dokter</th>
                                <th>Hari</th>
                                <th>Jam Mulai</th>
                                <th>Jam Selesai</th>
                                <th>Action/Status</th>
                            </tr>
                        </thead>
                        @foreach ($jadwalDokters as $jadwalDokter)
                            <tr>
                                <td>{{ $jadwalDokter->dokter->nama_dokter }}</td>
                                <td>{{ $jadwalDokter->hari }}</td>
                                <td>{{ \Carbon\Carbon::parse($jadwalDokter->jam_awal)->translatedFormat('H:i') }}</td>
                                <td>{{ \Carbon\Carbon::parse($jadwalDokter->jam_akhir)->translatedFormat('H:i') }}</td>
                                @if ($jadwalDokter->status === 'Pending')
                                    <td class="text-center">
                                        <a href="{{ route('jadwal-dokter.review', ['id' => $jadwalDokter->id_jadwal_dokter]) }}"
                                            class="btn btn-warning btn-circle">
                                            <i class="fas fa-fw fa-edit"></i>
                                        </a>
                                    </td>
                                @elseif($jadwalDokter->status === 'Canceled')
                                    <td class="text-center">
                                        <div class="text-danger">Canceled</div>
                                    </td>
                                @else
                                    <td class="text-center">
                                        <div class="text-success">Accepted</div>
                                    </td>
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
