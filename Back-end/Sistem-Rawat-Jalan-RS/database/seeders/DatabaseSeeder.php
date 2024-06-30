<?php

namespace Database\Seeders;

// use Illuminate\Database\Console\Seeds\WithoutModelEvents;

use App\Models\PendaftaranTemu;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;

class DatabaseSeeder extends Seeder
{
    protected static ?string $password;

    /**
     * Seed the application's database.
     */
    public function run(): void
    {
        // \App\Models\User::factory(100)->create();

        \App\Models\User::factory()->create([
            'username' => 'Admin RS Permata Hati',
            'email' => 'adminrsph@gmail.com',
            'password' => static::$password ??= Hash::make('password'),
            'role' => 'Admin'
        ]);

        \App\Models\User::factory()->create([
            'username' => 'Elvina',
            'email' => 'elvina.novitasari@gmail.com',
            'password' => static::$password ??= Hash::make('password'),
            'role' => 'Petugas Medis',
            'img_profile' => '/img/profiles/img_1715707027_petugas-medis-wanita.jpg'
        ]);

        DB::table('petugas_medis')->insert([
            'nama_petugas_medis' => 'Elvina Novitasari',
            'nip' => '76998969973356451',
            'jenis_kelamin' => 'Perempuan',
            'no_hp' => '086019972567',
            'alamat' => 'JL. Khatib Sulaiman No. 52, Padang',
            'user_id' => 2
        ]);

        \App\Models\User::factory()->create([
            'username' => 'Novi',
            'email' => 'novi.usamah@gmail.com',
            'password' => static::$password ??= Hash::make('password'),
            'role' => 'Apoteker',
            'img_profile' => '/img/profiles/img_1715707016_apoteker-wanita.jpg'
        ]);

        DB::table('apotekers')->insert([
            'nama_apoteker' => 'Novi Usamah',
            'no_sipa' => '517/7247/2600/8-73',
            'jenis_kelamin' => 'Perempuan',
            'no_hp' => '0817654606873',
            'alamat' => 'Jl Berlian Raya Bl R/2, Padang',
            'user_id' => 3
        ]);

        \App\Models\User::factory()->create([
            'username' => 'Irwan',
            'email' => 'irwan.prasetyo@gmail.com',
            'password' => static::$password ??= Hash::make('password'),
            'role' => 'Dokter',
            'img_profile' => '/img/profiles/img_1715707062_dokter-pria.jpg'
        ]);

        DB::table('dokters')->insert([
            'nama_dokter' => 'Irwan Prasetyo',
            'nip' => '270415370273692792',
            'jenis_kelamin' => 'Laki-Laki',
            'spesialis' => 'Poli Umum',
            'no_hp' => '0812345678',
            'alamat' => 'Jl Gajah Mada, Padang',
            'user_id' => 4
        ]);

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

        $this->call([
            // JadwalDokterSeeder::class,
            // ObatSeeder::class,
            // PendaftaranTemuSeeder::class
        ]);

        // \App\Models\Dokter::factory(10)->create();
    }
}
