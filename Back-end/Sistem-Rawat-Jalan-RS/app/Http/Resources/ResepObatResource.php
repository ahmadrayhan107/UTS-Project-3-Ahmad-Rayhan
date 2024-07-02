<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class ResepObatResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */
    public function toArray(Request $request): array
    {
        return [
            'nama_obat' => $this->obat->nama_obat,
            'dosis' => $this->dosis,
            'jenis_obat' => $this->jenis_obat,
            'keterangan' => $this->keterangan
        ];
    }
}
