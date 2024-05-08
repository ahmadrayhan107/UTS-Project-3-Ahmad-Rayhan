<?php

namespace App\Http\Middleware;

use Illuminate\Foundation\Http\Middleware\VerifyCsrfToken as Middleware;

class VerifyCsrfToken extends Middleware
{
    /**
     * The URIs that should be excluded from CSRF verification.
     *
     * @var array<int, string>
     */
    protected $except = [
        // 'api/v1/register',
        // 'api/v1/pasien',
        // 'api/v1/pasien/*',
        // 'api/v1/dokter',
        // 'api/v1/dokter/*',
        // 'api/v1/jadwal-dokter',
        // 'api/v1/pendaftaran-temu',
    ];
}
