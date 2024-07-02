<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class RekamMedisResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */
    public function toArray(Request $request): array
    {
        return [
            'id_rekam_medis' => $this->id_rekam_medis,
            'kode_rekam_medis' => $this->kode_rekam_medis,
            'tanggal' => \Carbon\Carbon::parse($this->tanggal_periksa)->translatedFormat('d F Y')
        ];
    }
}
