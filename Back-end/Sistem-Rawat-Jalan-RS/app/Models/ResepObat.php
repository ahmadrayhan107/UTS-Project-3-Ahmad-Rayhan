<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;

class ResepObat extends Model
{
    use HasFactory;

    protected $primaryKey = 'id_resep_obat';
    protected $fillable = ['tanggal', 'dosis', 'jenis_obat', 'keterangan', 'obat_id', 'rekam_medis_id'];
    public $timestamps = false;

    public function obat(): BelongsTo
    {
        return $this->belongsTo(Obat::class, 'obat_id', 'id_obat');
    }
}
