<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;

class Apoteker extends Model
{
    use HasFactory;
    protected $primaryKey = 'id_apoteker';
    protected $fillable = ['nama_apoteker', 'no_sipa', 'jenis_kelamin', 'no_hp', 'alamat', 'user_id'];
    public $timestamps = false;

    public function user(): BelongsTo
    {
        return $this->belongsTo(User::class, 'user_id', 'id_user');
    }
}
