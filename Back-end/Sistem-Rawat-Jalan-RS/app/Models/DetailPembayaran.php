<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class DetailPembayaran extends Model
{
    use HasFactory;

    protected $primaryKey = 'id_detail_pembayaran';
    protected $fillable = ['nama_tagihan', 'biaya', 'pembayaran_id'];
    public $timestamps = false;
}
