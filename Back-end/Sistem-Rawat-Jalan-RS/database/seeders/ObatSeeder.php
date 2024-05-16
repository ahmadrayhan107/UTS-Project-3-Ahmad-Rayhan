<?php

namespace Database\Seeders;

use App\Models\Obat;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class ObatSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $obats = 
        [
            [
                'nama_obat' => 'Silex Sirup 100 ml',
                'harga_obat' => '20000',
                'status' => 'Tersedia'
            ],
            [
                'nama_obat' => 'Procold Flu dan Batuk 6 Kaplet',
                'harga_obat' => '25000',
                'status' => 'Tersedia'
            ],
        ];

        Obat::insert($obats);
    }
}
