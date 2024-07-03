<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class DetailTransaksiResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */
    public function toArray(Request $request): array
    {
        return [
            'nota' => $this->nota,
            'tanggal_pembayaran' => \Carbon\Carbon::parse($this->tanggal_pembayaran)->translatedFormat('d F Y'),
            'total_biaya' => 'Rp' . $this->total_biaya,
            'status' => $this->status,
            'tagihan' => DetailTagihanResource::collection($this->detail)
        ];
    }
}
