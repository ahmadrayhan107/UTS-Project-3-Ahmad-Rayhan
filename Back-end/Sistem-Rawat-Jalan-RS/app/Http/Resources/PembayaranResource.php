<?php

namespace App\Http\Resources;

use App\Models\Obat;
use App\Models\PendaftaranTemu;
use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class PembayaranResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */

    public $collects = PendaftaranTemu::class;

    public function toArray(Request $request): array
    {
        $total_biaya = 50000;

        foreach ($this->details as $value) {
            $biaya = Obat::where('id_obat', $value['obat_id'])->first()->harga_obat;
            $total_biaya = $total_biaya + $biaya;
        }

        return [
            'details' => [DetailResource::collection($this->details)],
            'pendaftaran_temu_id' => $this->id_pendaftaran_temu,
            'pasien_id' => $this->pasien_id,
            'total_biaya' => $total_biaya
        ];
    }
}
