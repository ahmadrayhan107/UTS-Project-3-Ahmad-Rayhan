<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\HasOne;

class PendaftaranTemu extends Model
{
    use HasFactory;

    protected $primaryKey = 'id_pendaftaran_temu';
    protected $fillable = ['no_pendaftaran', 'tanggal_pendaftaran', 'jam', 'status', 'pasien_id', 'dokter_id'];
    public $timestamps = false;

    public function pasien(): BelongsTo
    {
        return $this->belongsTo(Pasien::class, 'pasien_id', 'id_pasien');
    }

    public function dokter(): BelongsTo
    {
        return $this->belongsTo(Dokter::class, 'dokter_id', 'id_dokter');
    }

    public function rekamMedis(): HasOne
    {
        return $this->hasOne(RekamMedis::class, 'pendaftaran_temu_id', 'id_pendaftaran_temu');
    }
}
