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
        Schema::create('pendaftaran_temus', function (Blueprint $table) {
            $table->increments('id_pendaftaran_temu');
            $table->string('no_pendaftaran', 5);
            $table->date('tanggal_pendaftaran');
            $table->time('jam');
            $table->string('status', 10);
            $table->integer('pasien_id')->unsigned();
            $table->foreign('pasien_id')->references('id_pasien')->on('pasiens');
            $table->integer('dokter_id')->unsigned();
            $table->foreign('dokter_id')->references('id_dokter')->on('dokters');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('pendaftaran_temus');
    }
};
