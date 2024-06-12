<?php

namespace Database\Seeders;

// use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;

use function PHPSTORM_META\map;

class DatabaseSeeder extends Seeder
{
    protected static ?string $password;

    /**
     * Seed the application's database.
     */
    public function run(): void
    {
        // \App\Models\User::factory(100)->create();

        // \App\Models\User::factory()->create([
        //     'username' => 'Admin RS',
        //     'email' => 'admin@gmail.com',
        //     'password' => static::$password ??= Hash::make('password'),
        //     'role' => 'Admin'
        // ]);

        // \App\Models\User::factory()->create([
        //     'username' => 'petugas-medis',
        //     'email' => 'petugas-medis@gmail.com',
        //     'password' => static::$password ??= Hash::make('password'),
        //     'role' => 'Petugas Medis',
        //     'img_profile' => '/img/profiles/img_1715707027_petugas-medis-wanita.png'
        // ]);

        // \App\Models\User::factory()->create([
        //     'username' => 'apoteker',
        //     'email' => 'apoteker@gmail.com',
        //     'password' => static::$password ??= Hash::make('password'),
        //     'role' => 'Apoteker',
        //     'img_profile' => '/img/profiles/img_1715707016_apoteker-wanita.png'
        // ]);

        // \App\Models\User::factory()->create([
        //     'username' => 'dokter-umum',
        //     'email' => 'dokter-umum@gmail.com',
        //     'password' => static::$password ??= Hash::make('password'),
        //     'role' => 'Dokter',
        //     'img_profile' => '/img/profiles/img_1715707062_dokter-pria.png'
        // ]);

        // \App\Models\User::factory()->create([
        //     'username' => 'pasien-1',
        //     'email' => 'pasien-1@gmail.com',
        //     'password' => static::$password ??= Hash::make('password'),
        //     'role' => 'Pasien',
        //     'img_profile' => '/img/profiles/img_1715707086_pasien-pria.png'
        // ]);

        // DB::table('pasiens')->insert([
        //     'nama_pasien' => 'Pasien Pertama',
        //     'nik' => '12345678901234',
        //     'jenis_kelamin' => 'Laki-Laki',
        //     'tempat_lahir' => 'Padang',
        //     'tanggal_lahir' => '2002-10-11',
        //     'no_hp' => '0812345681',
        //     'alamat' => 'Padang',
        //     'user_id' => 5
        // ]);

        // DB::table('dokters')->insert([
        //     'nama_dokter' => 'Dokter Umum',
        //     'nip' => '123456789012345678',
        //     'jenis_kelamin' => 'Laki-Laki',
        //     'spesialis' => 'Poli Umum',
        //     'no_hp' => '0812345678',
        //     'alamat' => 'Padang',
        //     'user_id' => 4
        // ]);

        // DB::table('petugas_medis')->insert([
        //     'nama_petugas_medis' => 'Petugas Medis',
        //     'nip' => '123456789012345679',
        //     'jenis_kelamin' => 'Perempuan',
        //     'no_hp' => '0812345679',
        //     'alamat' => 'Padang',
        //     'user_id' => 2
        // ]);

        // DB::table('apotekers')->insert([
        //     'nama_apoteker' => 'Apoteker',
        //     'no_sipa' => '001/0001/0001/1-01',
        //     'jenis_kelamin' => 'Perempuan',
        //     'no_hp' => '0812345680',
        //     'alamat' => 'Padang',
        //     'user_id' => 3
        // ]);

        // $this->call([
        //     JadwalDokterSeeder::class,
        //     ObatSeeder::class
        // ]);

        \App\Models\Dokter::factory(10)->create();
    }
}
