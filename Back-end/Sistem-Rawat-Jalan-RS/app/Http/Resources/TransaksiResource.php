<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class TransaksiResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */
    public function toArray(Request $request): array
    {
        return [
            'id_pembayaran' => $this->id_pembayaran,
            'nota' => $this->nota,
            'tanggal_pembayaran' => \Carbon\Carbon::parse($this->tanggal_pembayaran)->translatedFormat('d F Y'),
            'status' => $this->status,
            'total_biaya' => 'Rp' . $this->total_biaya
        ];
    }
}
