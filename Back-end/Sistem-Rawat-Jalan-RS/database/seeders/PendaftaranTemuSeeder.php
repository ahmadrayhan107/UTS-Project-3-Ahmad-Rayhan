<?php

namespace Database\Seeders;

use App\Models\PendaftaranTemu;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Carbon\Carbon;

class PendaftaranTemuSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $tanggal_pendaftaran = Carbon::now()->toDateString();

        $pendaftarans = [
            [
                'no_pendaftaran' => 'P001',
                'tanggal_pendaftaran' => $tanggal_pendaftaran,
                'jam' => fake()->time('H:i'),
                'status' => 'Terdaftar',
                'pasien_id' => 1,
                'dokter_id' => 1
            ],
            [
                'no_pendaftaran' => 'P002',
                'tanggal_pendaftaran' => $tanggal_pendaftaran,
                'jam' => fake()->time('H:i'),
                'status' => 'Terdaftar',
                'pasien_id' => 1,
                'dokter_id' => 1
            ],
            [
                'no_pendaftaran' => 'P003',
                'tanggal_pendaftaran' => $tanggal_pendaftaran,
                'jam' => fake()->time('H:i'),
                'status' => 'Terdaftar',
                'pasien_id' => 1,
                'dokter_id' => 1
            ],
            [
                'no_pendaftaran' => 'P004',
                'tanggal_pendaftaran' => $tanggal_pendaftaran,
                'jam' => fake()->time('H:i'),
                'status' => 'Terdaftar',
                'pasien_id' => 1,
                'dokter_id' => 1
            ],
            [
                'no_pendaftaran' => 'P005',
                'tanggal_pendaftaran' => $tanggal_pendaftaran,
                'jam' => fake()->time('H:i'),
                'status' => 'Terdaftar',
                'pasien_id' => 1,
                'dokter_id' => 1
            ],
            [
                'no_pendaftaran' => 'P006',
                'tanggal_pendaftaran' => $tanggal_pendaftaran,
                'jam' => fake()->time('H:i'),
                'status' => 'Terdaftar',
                'pasien_id' => 1,
                'dokter_id' => 1
            ],
            [
                'no_pendaftaran' => 'P001',
                'tanggal_pendaftaran' => $tanggal_pendaftaran,
                'jam' => fake()->time('H:i'),
                'status' => 'Terdaftar',
                'pasien_id' => 1,
                'dokter_id' => 1
            ],
            [
                'no_pendaftaran' => 'P007',
                'tanggal_pendaftaran' => $tanggal_pendaftaran,
                'jam' => fake()->time('H:i'),
                'status' => 'Terdaftar',
                'pasien_id' => 1,
                'dokter_id' => 1
            ],
            [
                'no_pendaftaran' => 'P008',
                'tanggal_pendaftaran' => $tanggal_pendaftaran,
                'jam' => fake()->time('H:i'),
                'status' => 'Terdaftar',
                'pasien_id' => 1,
                'dokter_id' => 1
            ],
            [
                'no_pendaftaran' => 'P009',
                'tanggal_pendaftaran' => $tanggal_pendaftaran,
                'jam' => fake()->time('H:i'),
                'status' => 'Terdaftar',
                'pasien_id' => 1,
                'dokter_id' => 1
            ],
            [
                'no_pendaftaran' => 'P010',
                'tanggal_pendaftaran' => $tanggal_pendaftaran,
                'jam' => fake()->time('H:i'),
                'status' => 'Terdaftar',
                'pasien_id' => 1,
                'dokter_id' => 1
            ],
        ];

        PendaftaranTemu::insert($pendaftarans);
    }
}
