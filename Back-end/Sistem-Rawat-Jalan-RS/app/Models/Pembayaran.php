<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\HasMany;

class Pembayaran extends Model
{
    use HasFactory;

    protected $primaryKey = 'id_pembayaran';
    protected $fillable = ['nota', 'total_biaya', 'tanggal_pembayaran', 'pasien_id', 'checkout_link', 'external_id', 'status'];
    public $timestamps = false;

    public function pasien(): BelongsTo
    {
        return $this->belongsTo(Pasien::class, 'pasien_id', 'id_pasien');
    }

    public function detail(): HasMany
    {
        return $this->hasMany(DetailPembayaran::class, 'pembayaran_id', 'id_pembayaran');
    }
}
