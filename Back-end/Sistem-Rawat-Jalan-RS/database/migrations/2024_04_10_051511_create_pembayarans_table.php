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
        Schema::create('pembayarans', function (Blueprint $table) {
            $table->increments('id_pembayaran');
            $table->string('nota', 15)->unique();
            $table->integer('total_biaya');
            $table->date('tanggal_pembayaran');
            $table->integer('pasien_id')->unsigned();
            $table->foreign('pasien_id')->references('id_pasien')->on('pasiens');
            $table->string('checkout_link', 100);
            $table->string('external_id', 50);
            $table->string('status', 20);
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('pembayarans');
    }
};
