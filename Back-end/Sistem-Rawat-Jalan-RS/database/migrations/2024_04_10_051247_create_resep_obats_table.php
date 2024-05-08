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
        Schema::create('resep_obats', function (Blueprint $table) {
            $table->increments('id_resep_obat');
            $table->string('dosis', 10);
            $table->string('jenis_obat', 15);
            $table->string('keterangan', 30);
            $table->integer('obat_id')->unsigned();
            $table->foreign('obat_id')->references('id_obat')->on('obats');
            $table->integer('pasien_id')->unsigned();
            $table->foreign('pasien_id')->references('id_pasien')->on('pasiens');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('resep_obats');
    }
};
