@extends('layouts.main')

@section('content')
    <div class="col-lg-12 mb-5">
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Insert Resep Obat</h1>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Nama Pasien</label>
                    <label class="col-sm-5">{{ $pendaftaranTemu->pasien->nama_pasien }}</label>
                </div>
            </div>
        </div>

        <div class="row mb-3 border-bottom">
            <div class="col-lg-12">
                <div class="form-group row">
                    <label class="col-sm-2 form-control-label">Nama Dokter</label>
                    <label class="col-sm-5">{{ $pendaftaranTemu->dokter->nama_dokter }}</label>
                </div>
            </div>
        </div>

        <form method="post" action="{{ route('resep-obat.store', ['pendaftaranTemu' => $pendaftaranTemu]) }}">
            @csrf
            <div id="show_item">

                <div class="row mb-3">

                    <div class="col-md-3 mb-2">
                        <select class="form-control form-control-user" required name="obat_id[]">
                            <option value="" selected> -- Pilih Obat -- </option>
                            @foreach ($obats as $obat)
                                <option value="{{ $obat->id_obat }}" @selected(old('obat_id') == $obat->id_obat)>{{ $obat->nama_obat }}
                                </option>
                            @endforeach
                        </select>
                    </div>

                    <div class="col-md-2 mb-2">
                        <input type="text" class="form-control form-control-user" required placeholder="Dosis : 2x1/hari"
                            value="{{ old('dosis') }}" name="dosis[]">
                    </div>

                    <div class="col-md-2 mb-2">
                        @php
                            $jenisObats = ['Tablet', 'Sirup', 'Bubuk'];
                        @endphp
                        <select class="form-control form-control-user" required name="jenis_obat[]">
                            <option value="" selected> -- Pilih Jenis Obat -- </option>
                            @foreach ($jenisObats as $jenisObat)
                                <option value="{{ $jenisObat }}" @selected(old('jenis_obat') == $jenisObat)>
                                    {{ $jenisObat }}</option>
                            @endforeach
                        </select>
                    </div>

                    <div class="col-md-3">
                        <textarea class="form-control form-control-user" required placeholder="Sebelum/Sesudah makan" rows="3"
                            name="keterangan[]">{{ old('keterangan') }}</textarea>
                    </div>

                    <div class="col-md-2">
                        <div class="btn btn-success" id="add">Add More</div>
                    </div>

                </div>

            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <script src="{{ asset('vendor/jquery/jquery.min.js') }}"></script>
    <script>
        var i = 0;
        $('#add').click(function() {
            $("#show_item").append(`
                <div class="row mb-3">

                    <div class="col-md-3 mb-2">
                        <select class="form-control form-control-user" required name="obat_id[]">
                            <option value="" selected> -- Pilih Obat -- </option>
                            @foreach ($obats as $obat)
                                <option value="{{ $obat->id_obat }}" @selected(old('obat_id') == $obat->id_obat)>{{ $obat->nama_obat }}
                                </option>
                            @endforeach
                        </select>
                    </div>

                    <div class="col-md-2 mb-2">
                        <input type="text" class="form-control form-control-user" required placeholder="Dosis : 2x1/hari"
                            value="{{ old('dosis') }}" name="dosis[]">
                    </div>

                    <div class="col-md-2 mb-2">
                        @php
                            $jenisObats = ['Tablet', 'Sirup', 'Bubuk'];
                        @endphp
                        <select class="form-control form-control-user" required name="jenis_obat[]">
                            <option value="" selected> -- Pilih Jenis Obat -- </option>
                            @foreach ($jenisObats as $jenisObat)
                                <option value="{{ $jenisObat }}" @selected(old('jenis_obat') == $jenisObat)>
                                    {{ $jenisObat }}</option>
                            @endforeach
                        </select>
                    </div>

                    <div class="col-md-3">
                        <textarea class="form-control form-control-user" required placeholder="Sebelum/Sesudah makan" rows="3"
                            name="keterangan[]">{{ old('keterangan') }}</textarea>
                    </div>

                    <div class="col-md-2">
                        <div class="btn btn-danger remove_item_btn">Remove</div>
                    </div>

                </div>
                                `);
        });

        $(document).on('click', '.remove_item_btn', function(e) {
            let row_item = $(this).parent().parent();
            $(row_item).remove();
        });
    </script>
@endsection
