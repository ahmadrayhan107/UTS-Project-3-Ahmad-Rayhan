<?php

namespace App\Http\Middleware;

use App\Models\JadwalDokter;
use Closure;
use Illuminate\Http\Request;
use Symfony\Component\HttpFoundation\Response;

class AdminMiddleware
{
    /**
     * Handle an incoming request.
     *
     * @param  \Closure(\Illuminate\Http\Request): (\Symfony\Component\HttpFoundation\Response)  $next
     */
    public function handle(Request $request, Closure $next): Response
    {
        if (Auth()->user()->role !== 'Admin') {
            abort(403);
        }

        // Notification
        $notificationCount = JadwalDokter::where('status', 'Pending')->where('seen', false)->count();

        if ($notificationCount !== 0) {
            if ($notificationCount > 9) {
                $request->session()->put('notificationCount', '9+');
            } else {
                $request->session()->put('notificationCount', $notificationCount);
            }
        } else {
            $request->session()->put('notificationCount', null);
        }

        $jadwalDokterPendings = JadwalDokter::where('status', 'Pending')->orderBy('id_jadwal_dokter', 'desc')->take(7)->get();
        $request->session()->put('jadwalDokterPendings', $jadwalDokterPendings);

        return $next($request);
    }
}
