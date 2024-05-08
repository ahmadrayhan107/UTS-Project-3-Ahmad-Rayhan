<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

    <!-- Sidebar Toggle (Topbar) -->
    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
        <i class="fa fa-bars"></i>
    </button>

    <!-- Topbar Navbar -->
    <ul class="navbar-nav ml-auto">

        @can('admin')
            <!-- Nav Item - Alerts -->
            <li class="nav-item dropdown no-arrow mx-1">
                <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-bell fa-fw"></i>
                    <!-- Counter - Alerts -->
                    <span class="badge badge-danger badge-counter">{{ Session::get('notificationCount') }}</span>
                </a>
                <!-- Dropdown - Alerts -->
                <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                    aria-labelledby="alertsDropdown">
                    <h6 class="dropdown-header">
                        Notification
                    </h6>
                    @php
                        $jadwalDokterPendings = Session::get('jadwalDokterPendings');
                    @endphp
                    @if ($jadwalDokterPendings)
                        @foreach ($jadwalDokterPendings as $jadwalDokterPending)
                            <a class="dropdown-item d-flex align-items-center"
                                href="{{ route('jadwal-dokter.review', ['id' => $jadwalDokterPending->id_jadwal_dokter]) }}">
                                <div class="mr-3">
                                    <div class="icon-circle bg-warning">
                                        <i class="fas fa-calendar text-white"></i>
                                    </div>
                                </div>
                                <div>
                                    <div class="small text-gray-500">
                                        {{ \Carbon\Carbon::parse($jadwalDokterPending->tanggal_praktek)->translatedFormat('F d, Y') }}
                                    </div>
                                    @if ($jadwalDokterPending->seen)
                                        {{ $jadwalDokterPending->dokter->nama_dokter }} mengajukan jadwal praktek
                                    @else
                                        <span class="font-weight-bold">{{ $jadwalDokterPending->dokter->nama_dokter }}
                                            mengajukan
                                            jadwal praktek</span>
                                    @endif
                                </div>
                            </a>
                        @endforeach
                    @endif
                    <a class="dropdown-item text-center small text-gray-500"
                        href="{{ route('jadwal-dokter.index.pending') }}">Show All Notification</a>
                </div>
            </li>

            <div class="topbar-divider d-none d-sm-block"></div>
        @endcan


        <!-- Nav Item - User Information -->
        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">{{ Auth()->user()->username }}</span>
                <img class="img-profile rounded-circle"
                    src="{{ $image = Auth()->user()->img_profile ? Auth()->user()->img_profile : asset('img/undraw_profile.svg') }}">
            </a>
            <!-- Dropdown - User Information -->
            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                @can('admin')
                    <a class="dropdown-item" href="{{ route('users.change-password') }}">
                        <i class="fas fa-lock fa-sm fa-fw mr-2 text-gray-400"></i>
                        Change Password
                    </a>
                @endcan
                @cannot('admin')
                    <a class="dropdown-item" href="{{ route('profile') }}">
                        <i class="fas fa-user-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                        Profile
                    </a>
                @endcannot
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                    Logout
                </a>
            </div>
        </li>

    </ul>

</nav>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <form action="{{ route('auth.logout') }}" method="post">
                    @csrf
                    <button class="btn btn-primary" type="submit">Logout</button>
                </form>
            </div>
        </div>
    </div>
</div>
