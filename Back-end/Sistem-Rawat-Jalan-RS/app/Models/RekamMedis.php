<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\HasMany;
use Illuminate\Database\Eloquent\Relations\HasManyThrough;

class RekamMedis extends Model
{
    use HasFactory;

    protected $primaryKey = 'id_rekam_medis';
    protected $fillable = ['kode_rekam_medis', 'tanggal_periksa', 'keluhan', 'diagnosa', 'tekanan_darah', 'suhu_tubuh', 'berat_badan', 'pasien_id', 'pendaftaran_temu_id'];
    public $timestamps = false;

    public function resepObat(): HasMany
    {
        return $this->hasMany(ResepObat::class, 'rekam_medis_id', 'id_rekam_medis');
    }

    public function infoObat(): HasManyThrough
    {
        return $this->hasManyThrough(
            Obat::class, 
            ResepObat::class, 
            'rekam_medis_id', 
            'obat_id',
            'id_rekam_medis',
            'id_obat'    
        );
    }
}
