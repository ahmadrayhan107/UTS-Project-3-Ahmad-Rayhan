<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class DokterResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */
    public function toArray(Request $request): array
    {
        return [
            "id_dokter" => $this->id_dokter,
            "nama_dokter" => $this->nama_dokter,
            "nip" => $this->nip,
            "jenis_kelamin" => $this->jenis_kelamin,
            "spesialis" => $this->spesialis,
            "no_hp" => $this->no_hp,
            "alamat" => $this->alamat,
            "user_id" => $this->user_id,
            "jadwalDokter" => $this->jadwalDokter
        ];
    }
}
