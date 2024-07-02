<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;
use App\Models\Pasien;
use App\Models\Dokter;

class AuthResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */
    public function toArray(Request $request): array
    {
        $userId = 0;

        if ($this->role === 'Pasien') {            
            $pasien = Pasien::select('id_pasien')->where('user_id', $this->id_user)->first();
            $userId = $pasien['id_pasien'];
        } elseif($this->role === 'Dokter') {
            $dokter = Dokter::select('id_dokter')->where('user_id', $this->id_user)->first();
            $userId = $dokter['id_dokter'];
        } else {
            $userId = 0;
        }

        return [
            'id_user'=> $this->id_user,
            'role'=> $this->role,
            'user_id' => $userId
        ];
    }
}
