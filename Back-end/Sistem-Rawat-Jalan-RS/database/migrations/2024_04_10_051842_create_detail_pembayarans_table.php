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
        Schema::create('detail_pembayarans', function (Blueprint $table) {
            $table->increments('id_detail_pembayaran');
            $table->string('nama_tagihan', 20);
            $table->integer('biaya');
            $table->integer('pembayaran_id')->unsigned();
            $table->foreign('pembayaran_id')->references('id_pembayaran')->on('pembayarans');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('detail_pembayarans');
    }
};
