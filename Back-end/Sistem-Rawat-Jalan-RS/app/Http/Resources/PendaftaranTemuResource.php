<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class PendaftaranTemuResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */
    public function toArray(Request $request): array
    {
        return [
            'nama_dokter' => $this->dokter->nama_dokter,
            'jam_awal' => \Carbon\Carbon::parse($this->jam)->translatedFormat('H:i'),
            'jam_akhir' => \Carbon\Carbon::parse(date("H:i:s", strtotime($this->jam. ' +1 hours')))->translatedFormat('H:i'),
            'tanggal_pendaftaran' => \Carbon\Carbon::parse($this->tanggal_pendaftaran)->translatedFormat('d F Y'),
            'img_profile' => $this->dokter->user->img_profile
        ];
    }
}
