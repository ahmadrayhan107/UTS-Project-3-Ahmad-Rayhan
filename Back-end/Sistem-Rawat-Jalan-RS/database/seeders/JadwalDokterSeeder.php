<?php

namespace Database\Seeders;

use App\Models\JadwalDokter;
use Carbon\Carbon;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class JadwalDokterSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $date1 = Carbon::yesterday();
        $date2 = Carbon::now();
        $date3 = Carbon::tomorrow();

        $hari1 = $date1->dayName;
        $hari2 = $date2->dayName;
        $hari3 = $date3->dayName;

        $jadwalDokters = 
        [
            [
                'hari' => $hari1,
                'jam_awal' => '08:00:00',
                'jam_akhir' => '12:00:00',
                'status' => 'Accepted',
                'seen' => true,
                'dokter_id' => 1,
            ],
            [
                'hari' => $hari2,
                'jam_awal' => '08:00:00',
                'jam_akhir' => '12:00:00',
                'status' => 'Accepted',
                'seen' => true,
                'dokter_id' => 1,
            ],
            [
                'hari' => $hari3,
                'jam_awal' => '08:00:00',
                'jam_akhir' => '12:00:00',
                'status' => 'Accepted',
                'seen' => true,
                'dokter_id' => 1,
            ],
        ];

        JadwalDokter::insert($jadwalDokters);
    }
}
