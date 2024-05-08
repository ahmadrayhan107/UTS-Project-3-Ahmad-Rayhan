<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;

class JadwalDokter extends Model
{
    use HasFactory;
    protected $primaryKey = 'id_jadwal_dokter';
    protected $fillable = ['hari', 'jam_awal', 'jam_akhir', 'status', 'seen', 'dokter_id'];
    public $timestamps = false;

    public function dokter(): BelongsTo
    {
        return $this->belongsTo(Dokter::class, 'dokter_id', 'id_dokter');
    }
}
