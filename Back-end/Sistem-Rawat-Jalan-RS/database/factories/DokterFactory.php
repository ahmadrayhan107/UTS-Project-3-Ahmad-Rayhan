<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use Illuminate\Support\Facades\Hash;
use App\Models\User;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Dokter>
 */
class DokterFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        $gender = fake()->randomElement(['male', 'female']);

        $image_profile = ($gender == 'male') ? '/img/profiles/img_1715707062_dokter-pria.png' : '/img/profiles/img_1715707063_dokter-wanita.png';

        $jenis_kelamin = ($gender == 'male') ? 'Laki-Laki' : 'Perempuan';

        $firstName = fake()->firstName($gender);

        \App\Models\User::factory()->create([
            'username' => $firstName,
            'email' => $firstName . '@gmail.com',
            'password' => Hash::make('password'),
            'role' => 'Dokter',
            'img_profile' => $image_profile
        ]);

        $user_id = User::orderByDesc('id_user')->first();

        return [
            'nama_dokter' => fake()->lastName($gender),
            'nip' => fake()->nik(),
            'jenis_kelamin' => $jenis_kelamin,
            'spesialis' => fake()->randomElement(['Poli Umum', 'Poli Anak', 'Poli Gigi', 'Poli Bedah', 'Poli THT']),
            'no_hp' => fake()->randomNumber(9, true),
            'alamat' => fake()->city(),
            'user_id' => $user_id
        ];
    }
}
