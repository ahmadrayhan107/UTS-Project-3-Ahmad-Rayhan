<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('dokters', function (Blueprint $table) {
            $table->increments('id_dokter');
            $table->string('nama_dokter', 30);
            $table->string('nip', 18)->unique();
            $table->string('jenis_kelamin', 10);
            $table->string('spesialis', 15);
            $table->string('no_hp', 15)->unique();
            $table->string('alamat', 50);
            $table->integer('user_id')->unsigned();
            $table->foreign('user_id')->references('id_user')->on('users');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('dokters');
    }
};
