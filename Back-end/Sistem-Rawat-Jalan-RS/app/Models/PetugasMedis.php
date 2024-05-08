<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;

class PetugasMedis extends Model
{
    use HasFactory;
    protected $primaryKey = 'id_petugas_medis';
    protected $fillable = ['nama_petugas_medis', 'nip', 'jenis_kelamin', 'no_hp', 'alamat', 'user_id'];
    public $timestamps = false;

    public function user(): BelongsTo
    {
        return $this->belongsTo(User::class, 'user_id', 'id_user');
    }
}
