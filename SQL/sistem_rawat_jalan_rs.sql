-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 08 Bulan Mei 2024 pada 08.51
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistem_rawat_jalan_rs`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `apotekers`
--

CREATE TABLE `apotekers` (
  `id_apoteker` int(10) UNSIGNED NOT NULL,
  `nama_apoteker` varchar(30) NOT NULL,
  `no_sipa` varchar(18) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_pembayarans`
--

CREATE TABLE `detail_pembayarans` (
  `id_detail_pembayaran` int(10) UNSIGNED NOT NULL,
  `nama_tagihan` varchar(20) NOT NULL,
  `biaya` int(11) NOT NULL,
  `pembayaran_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `dokters`
--

CREATE TABLE `dokters` (
  `id_dokter` int(10) UNSIGNED NOT NULL,
  `nama_dokter` varchar(30) NOT NULL,
  `nip` varchar(18) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `spesialis` varchar(15) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `dokters`
--

INSERT INTO `dokters` (`id_dokter`, `nama_dokter`, `nip`, `jenis_kelamin`, `spesialis`, `no_hp`, `alamat`, `user_id`) VALUES
(1, 'Dokter Umum', '123456789012345678', 'Laki-Laki', 'Poli Umum', '0812345679', 'Padang', 4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `failed_jobs`
--

CREATE TABLE `failed_jobs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `uuid` varchar(255) NOT NULL,
  `connection` text NOT NULL,
  `queue` text NOT NULL,
  `payload` longtext NOT NULL,
  `exception` longtext NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `jadwal_dokters`
--

CREATE TABLE `jadwal_dokters` (
  `id_jadwal_dokter` int(10) UNSIGNED NOT NULL,
  `hari` varchar(10) NOT NULL,
  `jam_awal` time NOT NULL,
  `jam_akhir` time NOT NULL,
  `status` varchar(10) NOT NULL,
  `seen` tinyint(1) DEFAULT NULL,
  `dokter_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `jadwal_dokters`
--

INSERT INTO `jadwal_dokters` (`id_jadwal_dokter`, `hari`, `jam_awal`, `jam_akhir`, `status`, `seen`, `dokter_id`) VALUES
(1, 'Senin', '08:00:00', '12:00:00', 'Accepted', 1, 1),
(2, 'Selasa', '08:00:00', '12:00:00', 'Accepted', 1, 1),
(3, 'Rabu', '08:00:00', '12:00:00', 'Accepted', 1, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2014_10_12_000000_create_users_table', 1),
(2, '2014_10_12_100000_create_password_reset_tokens_table', 1),
(3, '2019_08_19_000000_create_failed_jobs_table', 1),
(4, '2024_04_10_035106_create_petugas_medis_table', 1),
(5, '2024_04_10_045304_create_apotekers_table', 1),
(6, '2024_04_10_045554_create_dokters_table', 1),
(7, '2024_04_10_045650_create_pasiens_table', 1),
(8, '2024_04_10_045803_create_jadwal_dokters_table', 1),
(9, '2024_04_10_050429_create_pendaftaran_temus_table', 1),
(10, '2024_04_10_050706_create_rekam_medis_table', 1),
(11, '2024_04_10_051129_create_obats_table', 1),
(12, '2024_04_10_051247_create_resep_obats_table', 1),
(13, '2024_04_10_051511_create_pembayarans_table', 1),
(14, '2024_04_10_051842_create_detail_pembayarans_table', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `obats`
--

CREATE TABLE `obats` (
  `id_obat` int(10) UNSIGNED NOT NULL,
  `nama_obat` varchar(30) NOT NULL,
  `harga_obat` int(11) NOT NULL,
  `status` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `obats`
--

INSERT INTO `obats` (`id_obat`, `nama_obat`, `harga_obat`, `status`) VALUES
(1, 'Silex Sirup 100 ml', 30000, 'Tersedia'),
(2, 'Procold Flu dan Batuk 6 Kaplet', 25000, 'Tersedia');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pasiens`
--

CREATE TABLE `pasiens` (
  `id_pasien` int(10) UNSIGNED NOT NULL,
  `nama_pasien` varchar(30) NOT NULL,
  `nik` varchar(14) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `tempat_lahir` varchar(15) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `pasiens`
--

INSERT INTO `pasiens` (`id_pasien`, `nama_pasien`, `nik`, `jenis_kelamin`, `tempat_lahir`, `tanggal_lahir`, `no_hp`, `alamat`, `user_id`) VALUES
(1, 'Pasien Pertama', '12345678901234', 'Laki-Laki', 'Padang', '2002-10-11', '0812345678', 'Padang', 5),
(2, 'Pasien Kedua', '12345678901235', 'Perempuan', 'Padang', '2003-10-10', '0812345682', 'Padang', 6),
(3, 'Pasien Ketiga', '12345678901236', 'Laki-Laki', 'Bukittingi', '2002-10-04', '0812345683', 'Padang', 7),
(4, 'Pasien Keempat', '12345678901237', 'Laki-Laki', 'Pekanbaru', '2000-08-17', '0812345684', 'Padang', 8);

-- --------------------------------------------------------

--
-- Struktur dari tabel `password_reset_tokens`
--

CREATE TABLE `password_reset_tokens` (
  `email` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembayarans`
--

CREATE TABLE `pembayarans` (
  `id_pembayaran` int(10) UNSIGNED NOT NULL,
  `total_biaya` int(11) NOT NULL,
  `tanggal_pembayaran` date NOT NULL,
  `pasien_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pendaftaran_temus`
--

CREATE TABLE `pendaftaran_temus` (
  `id_pendaftaran_temu` int(10) UNSIGNED NOT NULL,
  `no_pendaftaran` varchar(5) NOT NULL,
  `tanggal_pendaftaran` date NOT NULL,
  `jam` time NOT NULL,
  `status` varchar(10) NOT NULL,
  `pasien_id` int(10) UNSIGNED NOT NULL,
  `dokter_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `pendaftaran_temus`
--

INSERT INTO `pendaftaran_temus` (`id_pendaftaran_temu`, `no_pendaftaran`, `tanggal_pendaftaran`, `jam`, `status`, `pasien_id`, `dokter_id`) VALUES
(1, 'P001', '2024-05-06', '10:00:00', 'Pending', 1, 1),
(2, 'P001', '2024-05-07', '10:00:00', 'Pending', 1, 1),
(3, 'P001', '2024-05-08', '12:00:00', 'Pending', 1, 1),
(5, 'P002', '2024-05-07', '09:00:00', 'Terdaftar', 2, 1),
(6, 'P003', '2024-05-07', '09:00:00', 'Terdaftar', 3, 1),
(7, 'P004', '2024-05-07', '08:00:00', 'Terdaftar', 4, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `petugas_medis`
--

CREATE TABLE `petugas_medis` (
  `id_petugas_medis` int(10) UNSIGNED NOT NULL,
  `nama_petugas_medis` varchar(30) NOT NULL,
  `nip` varchar(18) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `petugas_medis`
--

INSERT INTO `petugas_medis` (`id_petugas_medis`, `nama_petugas_medis`, `nip`, `jenis_kelamin`, `no_hp`, `alamat`, `user_id`) VALUES
(1, 'Petugas Medis', '123456789012345679', 'Perempuan', '0812345680', 'Padang', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `rekam_medis`
--

CREATE TABLE `rekam_medis` (
  `id_rekam_medis` int(10) UNSIGNED NOT NULL,
  `kode_rekam_medis` varchar(10) NOT NULL,
  `tanggal_periksa` date NOT NULL,
  `keluhan` varchar(30) DEFAULT NULL,
  `diagnosa` varchar(30) DEFAULT NULL,
  `tekanan_darah` varchar(5) DEFAULT NULL,
  `suhu_tubuh` varchar(3) DEFAULT NULL,
  `berat_badan` varchar(3) DEFAULT NULL,
  `pasien_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `rekam_medis`
--

INSERT INTO `rekam_medis` (`id_rekam_medis`, `kode_rekam_medis`, `tanggal_periksa`, `keluhan`, `diagnosa`, `tekanan_darah`, `suhu_tubuh`, `berat_badan`, `pasien_id`) VALUES
(17, 'RM001', '2024-05-07', 'Badan panas', 'Demam', '100', '45', '65', 1),
(18, 'RM002', '2024-05-08', 'Badan panas', 'Demam', '100', '45', '65', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `resep_obats`
--

CREATE TABLE `resep_obats` (
  `id_resep_obat` int(10) UNSIGNED NOT NULL,
  `dosis` varchar(10) NOT NULL,
  `jenis_obat` varchar(15) NOT NULL,
  `keterangan` varchar(30) NOT NULL,
  `obat_id` int(10) UNSIGNED NOT NULL,
  `pasien_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `resep_obats`
--

INSERT INTO `resep_obats` (`id_resep_obat`, `dosis`, `jenis_obat`, `keterangan`, `obat_id`, `pasien_id`) VALUES
(10, '3x1/hari', 'Sirup', 'Sesudah makan', 1, 1),
(11, '2x1/hari', 'Tablet', 'Sesudah makan', 2, 1),
(12, '2x1/hari', 'Sirup', 'Sebelum makan', 1, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id_user` int(10) UNSIGNED NOT NULL,
  `username` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(60) NOT NULL,
  `role` varchar(15) NOT NULL,
  `last_login` timestamp NULL DEFAULT NULL,
  `img_profile` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id_user`, `username`, `email`, `password`, `role`, `last_login`, `img_profile`) VALUES
(1, 'Admin RS', 'admin@gmail.com', '$2y$10$Z/8lt8jvYM1ectIgCdZ/U.2YwT4k.kHz6XrtvdGYLa5VxgBGaLz/y', 'Admin', '2024-05-07 22:01:57', NULL),
(2, 'petugas-medis', 'petugas-medis@gmail.com', '$2y$10$NcYiMpUoDNzFmyqmjt2sZeucSMRAxXzfO9ELS8/S4Sti4TdCQq1Uu', 'Petugas Medis', '2024-05-07 22:02:52', NULL),
(3, 'apoteker', 'apoteker@gmail.com', '$2y$10$8oIJLgsDPAss4n2gzqNg/uOjbS/JS/CiGk3iXVd6SlJdbU.F0ZHhi', 'Apoteker', '2024-05-07 20:28:27', NULL),
(4, 'dokter-umum', 'dokter-umum@gmail.com', '$2y$10$Unglh.GLMYnnlGTDEP4ppeFwR8TMXsv5V8k3dp0clfCIUK3XGryR6', 'Dokter', '2024-05-06 16:07:20', NULL),
(5, 'pasien-1', 'pasien-1@gmail.com', '$2y$10$qiXnLkAC9d0VTVPYxEbv3uYODl4vWM0rQ3yZAzQJkt/7NVXP73ojq', 'Pasien', NULL, NULL),
(6, 'pasien-2', 'pasien-2@gmail.com', '$2y$10$S9vPh0p1MF4vmtVhERawnOgOKqEmrTI3ScpT4.Vi8fRuP6and/39m', 'Pasien', '2024-05-06 22:56:23', NULL),
(7, 'pasien-3', 'pasien-3@gmail.com', '$2y$10$qVFYi62UvGUX3zeHOtW9p.Md6HW4lAxkXN/zCPy/8xhcAnMO2i026', 'Pasien', NULL, NULL),
(8, 'pasien-4', 'pasien-4@gmail.com', '$2y$10$avLlwyG3qUwoR0KYsmrNx.gGD9HOSodfZl1N35oVf4dtGreLrUb7q', 'Pasien', '2024-05-06 23:01:29', NULL);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `apotekers`
--
ALTER TABLE `apotekers`
  ADD PRIMARY KEY (`id_apoteker`),
  ADD UNIQUE KEY `apotekers_no_sipa_unique` (`no_sipa`),
  ADD UNIQUE KEY `apotekers_no_hp_unique` (`no_hp`),
  ADD KEY `apotekers_user_id_foreign` (`user_id`);

--
-- Indeks untuk tabel `detail_pembayarans`
--
ALTER TABLE `detail_pembayarans`
  ADD PRIMARY KEY (`id_detail_pembayaran`),
  ADD KEY `detail_pembayarans_pembayaran_id_foreign` (`pembayaran_id`);

--
-- Indeks untuk tabel `dokters`
--
ALTER TABLE `dokters`
  ADD PRIMARY KEY (`id_dokter`),
  ADD UNIQUE KEY `dokters_nip_unique` (`nip`),
  ADD UNIQUE KEY `dokters_no_hp_unique` (`no_hp`),
  ADD KEY `dokters_user_id_foreign` (`user_id`);

--
-- Indeks untuk tabel `failed_jobs`
--
ALTER TABLE `failed_jobs`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `failed_jobs_uuid_unique` (`uuid`);

--
-- Indeks untuk tabel `jadwal_dokters`
--
ALTER TABLE `jadwal_dokters`
  ADD PRIMARY KEY (`id_jadwal_dokter`),
  ADD KEY `jadwal_dokters_dokter_id_foreign` (`dokter_id`);

--
-- Indeks untuk tabel `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `obats`
--
ALTER TABLE `obats`
  ADD PRIMARY KEY (`id_obat`);

--
-- Indeks untuk tabel `pasiens`
--
ALTER TABLE `pasiens`
  ADD PRIMARY KEY (`id_pasien`),
  ADD UNIQUE KEY `pasiens_nik_unique` (`nik`),
  ADD UNIQUE KEY `pasiens_no_hp_unique` (`no_hp`),
  ADD KEY `pasiens_user_id_foreign` (`user_id`);

--
-- Indeks untuk tabel `password_reset_tokens`
--
ALTER TABLE `password_reset_tokens`
  ADD PRIMARY KEY (`email`);

--
-- Indeks untuk tabel `pembayarans`
--
ALTER TABLE `pembayarans`
  ADD PRIMARY KEY (`id_pembayaran`),
  ADD KEY `pembayarans_pasien_id_foreign` (`pasien_id`);

--
-- Indeks untuk tabel `pendaftaran_temus`
--
ALTER TABLE `pendaftaran_temus`
  ADD PRIMARY KEY (`id_pendaftaran_temu`),
  ADD KEY `pendaftaran_temus_pasien_id_foreign` (`pasien_id`),
  ADD KEY `pendaftaran_temus_dokter_id_foreign` (`dokter_id`);

--
-- Indeks untuk tabel `petugas_medis`
--
ALTER TABLE `petugas_medis`
  ADD PRIMARY KEY (`id_petugas_medis`),
  ADD UNIQUE KEY `petugas_medis_nip_unique` (`nip`),
  ADD UNIQUE KEY `petugas_medis_no_hp_unique` (`no_hp`),
  ADD KEY `petugas_medis_user_id_foreign` (`user_id`);

--
-- Indeks untuk tabel `rekam_medis`
--
ALTER TABLE `rekam_medis`
  ADD PRIMARY KEY (`id_rekam_medis`),
  ADD UNIQUE KEY `rekam_medis_kode_rekam_medis_unique` (`kode_rekam_medis`),
  ADD KEY `rekam_medis_pasien_id_foreign` (`pasien_id`);

--
-- Indeks untuk tabel `resep_obats`
--
ALTER TABLE `resep_obats`
  ADD PRIMARY KEY (`id_resep_obat`),
  ADD KEY `resep_obats_obat_id_foreign` (`obat_id`),
  ADD KEY `resep_obats_pasien_id_foreign` (`pasien_id`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `apotekers`
--
ALTER TABLE `apotekers`
  MODIFY `id_apoteker` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `detail_pembayarans`
--
ALTER TABLE `detail_pembayarans`
  MODIFY `id_detail_pembayaran` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `dokters`
--
ALTER TABLE `dokters`
  MODIFY `id_dokter` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `failed_jobs`
--
ALTER TABLE `failed_jobs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `jadwal_dokters`
--
ALTER TABLE `jadwal_dokters`
  MODIFY `id_jadwal_dokter` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT untuk tabel `obats`
--
ALTER TABLE `obats`
  MODIFY `id_obat` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `pasiens`
--
ALTER TABLE `pasiens`
  MODIFY `id_pasien` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `pembayarans`
--
ALTER TABLE `pembayarans`
  MODIFY `id_pembayaran` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `pendaftaran_temus`
--
ALTER TABLE `pendaftaran_temus`
  MODIFY `id_pendaftaran_temu` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `petugas_medis`
--
ALTER TABLE `petugas_medis`
  MODIFY `id_petugas_medis` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `rekam_medis`
--
ALTER TABLE `rekam_medis`
  MODIFY `id_rekam_medis` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT untuk tabel `resep_obats`
--
ALTER TABLE `resep_obats`
  MODIFY `id_resep_obat` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `apotekers`
--
ALTER TABLE `apotekers`
  ADD CONSTRAINT `apotekers_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id_user`);

--
-- Ketidakleluasaan untuk tabel `detail_pembayarans`
--
ALTER TABLE `detail_pembayarans`
  ADD CONSTRAINT `detail_pembayarans_pembayaran_id_foreign` FOREIGN KEY (`pembayaran_id`) REFERENCES `pembayarans` (`id_pembayaran`);

--
-- Ketidakleluasaan untuk tabel `dokters`
--
ALTER TABLE `dokters`
  ADD CONSTRAINT `dokters_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id_user`);

--
-- Ketidakleluasaan untuk tabel `jadwal_dokters`
--
ALTER TABLE `jadwal_dokters`
  ADD CONSTRAINT `jadwal_dokters_dokter_id_foreign` FOREIGN KEY (`dokter_id`) REFERENCES `dokters` (`id_dokter`);

--
-- Ketidakleluasaan untuk tabel `pasiens`
--
ALTER TABLE `pasiens`
  ADD CONSTRAINT `pasiens_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id_user`);

--
-- Ketidakleluasaan untuk tabel `pembayarans`
--
ALTER TABLE `pembayarans`
  ADD CONSTRAINT `pembayarans_pasien_id_foreign` FOREIGN KEY (`pasien_id`) REFERENCES `pasiens` (`id_pasien`);

--
-- Ketidakleluasaan untuk tabel `pendaftaran_temus`
--
ALTER TABLE `pendaftaran_temus`
  ADD CONSTRAINT `pendaftaran_temus_dokter_id_foreign` FOREIGN KEY (`dokter_id`) REFERENCES `dokters` (`id_dokter`),
  ADD CONSTRAINT `pendaftaran_temus_pasien_id_foreign` FOREIGN KEY (`pasien_id`) REFERENCES `pasiens` (`id_pasien`);

--
-- Ketidakleluasaan untuk tabel `petugas_medis`
--
ALTER TABLE `petugas_medis`
  ADD CONSTRAINT `petugas_medis_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id_user`);

--
-- Ketidakleluasaan untuk tabel `rekam_medis`
--
ALTER TABLE `rekam_medis`
  ADD CONSTRAINT `rekam_medis_pasien_id_foreign` FOREIGN KEY (`pasien_id`) REFERENCES `pasiens` (`id_pasien`);

--
-- Ketidakleluasaan untuk tabel `resep_obats`
--
ALTER TABLE `resep_obats`
  ADD CONSTRAINT `resep_obats_obat_id_foreign` FOREIGN KEY (`obat_id`) REFERENCES `obats` (`id_obat`),
  ADD CONSTRAINT `resep_obats_pasien_id_foreign` FOREIGN KEY (`pasien_id`) REFERENCES `pasiens` (`id_pasien`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
