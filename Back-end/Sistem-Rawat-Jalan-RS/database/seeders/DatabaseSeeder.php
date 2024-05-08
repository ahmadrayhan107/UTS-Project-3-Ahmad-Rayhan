<?php

namespace Database\Seeders;

// use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
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
            'username' => 'Admin RS',
            'email' => 'admin@gmail.com',
            'password' => static::$password ??= Hash::make('password'),
            'role' => 'Admin'
        ]);
    }
}
