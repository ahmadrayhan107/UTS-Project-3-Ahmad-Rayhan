<?php

namespace App\Models;

use Carbon\Carbon;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\HasMany;

class Dokter extends Model
{
    use HasFactory;
    protected $primaryKey = 'id_dokter';
    protected $fillable = ['nama_dokter', 'nip', 'jenis_kelamin', 'spesialis', 'no_hp', 'alamat', 'user_id'];
    public $timestamps = false;

    public function user(): BelongsTo
    {
        return $this->belongsTo(User::class, 'user_id', 'id_user');
    }

    public function jadwalDokter(): HasMany
    {
        return $this->hasMany(JadwalDokter::class, 'dokter_id', 'id_dokter')->where('status', 'Accepted');
    }
}
