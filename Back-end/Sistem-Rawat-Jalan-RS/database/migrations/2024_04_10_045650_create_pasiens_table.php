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
        Schema::create('pasiens', function (Blueprint $table) {
            $table->increments('id_pasien');
            $table->string('nama_pasien', 30);
            $table->string('no_bpjs', 11);
            $table->string('nik', 14)->unique();
            $table->string('jenis_kelamin', 10);
            $table->string('tempat_lahir', 15);
            $table->date('tanggal_lahir');
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
        Schema::dropIfExists('pasiens');
    }
};
