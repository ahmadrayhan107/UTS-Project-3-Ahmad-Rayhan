<?php

namespace App\Http\Resources;

use App\Models\ResepObat;
use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class DetailResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */

    public $collects = ResepObat::class;
    public function toArray(Request $request): array
    {
        return [
            'nama_tagihan' => $this->obat->nama_obat,
            'biaya' => $this->obat->harga_obat
        ];
    }
}
