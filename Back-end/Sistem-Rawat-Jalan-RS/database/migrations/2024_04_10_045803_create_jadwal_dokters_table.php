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
        Schema::create('jadwal_dokters', function (Blueprint $table) {
            $table->increments('id_jadwal_dokter');
            $table->string('hari', 10);
            $table->time('jam_awal');
            $table->time('jam_akhir');
            $table->string('status', 10);
            $table->boolean('seen')->nullable();
            $table->integer('dokter_id')->unsigned();
            $table->foreign('dokter_id')->references('id_dokter')->on('dokters');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('jadwal_dokters');
    }
};
