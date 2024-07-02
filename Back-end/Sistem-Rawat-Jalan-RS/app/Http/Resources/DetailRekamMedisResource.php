<?php

namespace App\Http\Resources;

use App\Models\ResepObat;
use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class DetailRekamMedisResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */
    public function toArray(Request $request): array
    {
        return [
            'keluhan' => $this->keluhan,
            'diagnosa' => $this->diagnosa,
            'tekanan_darah' => $this->tekanan_darah . ' mmHg',
            'berat_badan' => $this->berat_badan . 'Kg',
            'suhu_tubuh' => $this->suhu_tubuh . '°C',
            'obats' => ResepObatResource::collection($this->resepObat)
        ];
    }
}
