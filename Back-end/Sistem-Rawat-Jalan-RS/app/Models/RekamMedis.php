<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\HasMany;

class RekamMedis extends Model
{
    use HasFactory;

    protected $primaryKey = 'id_rekam_medis';
    protected $fillable = ['kode_rekam_medis', 'tanggal_periksa', 'keluhan', 'diagnosa', 'tekanan_darah', 'suhu_tubuh', 'berat_badan', 'pasien_id'];
    public $timestamps = false;

    public function resepObat(): HasMany
    {
        return $this->hasMany(ResepObat::class, 'rekam_medis_id', 'id_rekam_medis');
    }
}
