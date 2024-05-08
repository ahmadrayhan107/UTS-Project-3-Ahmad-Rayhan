<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="">
        <div class="sidebar-brand-icon rotate-n-15">
            <img src="{{ asset('img/logo-sisrawat.png') }}" alt="" class="img-fluid">
        </div>
        <div class="sidebar-brand-text mx-1">SISRAWAT</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item @yield('sideDashboard')">
        <a class="nav-link" href="{{ route('dashboard') }}">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Nav Item - Tables -->
    @can('admin')
        <li class="nav-item @yield('sideUser')">
            <a class="nav-link" href="{{ route('users.index') }}">
                <i class="fas fa-fw fa-table"></i>
                <span>Users</span>
            </a>
        </li>
        <li class="nav-item @yield('sidePasien')">
            <a class="nav-link" href="{{ route('pasien.index') }}">
                <i class="fas fa-fw fa-table"></i>
                <span>Pasien</span>
            </a>
        </li>
        <li class="nav-item @yield('sideDokter')">
            <a class="nav-link" href="{{ route('dokter.index') }}">
                <i class="fas fa-fw fa-table"></i>
                <span>Dokter</span>
            </a>
        </li>
        <li class="nav-item @yield('sidePetugasMedis')">
            <a class="nav-link" href="{{ route('petugas-medis.index') }}">
                <i class="fas fa-fw fa-table"></i>
                <span>Petugas Medis</span>
            </a>
        </li>
        <li class="nav-item @yield('sideApoteker')">
            <a class="nav-link" href="{{ route('apoteker.index') }}">
                <i class="fas fa-fw fa-table"></i>
                <span>Apoteker</span>
            </a>
        </li>
        <li class="nav-item @yield('sideJadwalDokter')">
            <a class="nav-link" href={{ route('jadwal-dokter.index') }}>
                <i class="fas fa-fw fa-table"></i>
                <span>Jadwal Dokter</span>
            </a>
        </li>
        <li class="nav-item @yield('sidePembayaran')">
            <a class="nav-link" href={{ route('pembayaran.index') }}>
                <i class="fas fa-fw fa-table"></i>
                <span>Pembayaran</span>
            </a>
        </li>
    @endcan

    @can('petugas-medis')
        <li class="nav-item @yield('sidePendaftaranTemu')">
            <a class="nav-link" href="{{ route('pendaftaran-temu') }}">
                <i class="fas fa-fw fa-table"></i>
                <span>Pendaftaran Temu</span>
            </a>
        </li>
    @endcan

    @can('apoteker')
        <li class="nav-item @yield('sideObat')">
            <a class="nav-link" href="{{ route('obat.index') }}">
                <i class="fas fa-fw fa-table"></i>
                <span>Obat</span>
            </a>
        </li>
    @endcan

    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

</ul>
