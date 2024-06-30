<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\HasMany;

class Pasien extends Model
{
    use HasFactory;
    protected $primaryKey = 'id_pasien';
    protected $fillable = ['nama_pasien', 'no_bpjs', 'nik', 'jenis_kelamin', 'tempat_lahir', 'tanggal_lahir', 'no_hp', 'alamat', 'user_id'];
    public $timestamps = false;

    public function user(): BelongsTo
    {
        return $this->belongsTo(User::class, 'user_id', 'id_user');
    }

    public function rekamMedis(): HasMany
    {
        return $this->hasMany(RekamMedis::class, 'pasien_id', 'id_pasien');
    }
}
