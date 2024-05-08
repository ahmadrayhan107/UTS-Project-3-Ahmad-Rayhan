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
        Schema::create('rekam_medis', function (Blueprint $table) {
            $table->increments('id_rekam_medis');
            $table->string('kode_rekam_medis', 10)->unique();
            $table->date('tanggal_periksa');
            $table->string('keluhan', 30)->nullable();
            $table->string('diagnosa', 30)->nullable();
            $table->string('tekanan_darah', 5)->nullable();
            $table->string('suhu_tubuh', 3)->nullable();
            $table->string('berat_badan', 3)->nullable();
            $table->integer('pasien_id')->unsigned();
            $table->foreign('pasien_id')->references('id_pasien')->on('pasiens');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('rekam_medis');
    }
};
