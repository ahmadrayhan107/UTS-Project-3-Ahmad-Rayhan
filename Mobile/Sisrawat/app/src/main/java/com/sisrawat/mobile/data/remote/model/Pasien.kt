package com.sisrawat.mobile.data.remote.model

import com.google.gson.annotations.SerializedName

data class Pasien(
    @field:SerializedName("nama_pasien")
    val namaPasien: String,
    @field:SerializedName("no_bpjs")
    val noBpjs: String,
    @field:SerializedName("nik")
    val nik: String,
    @field:SerializedName("jenis_kelamin")
    val jenisKelamin: String,
    @field:SerializedName("tanggal_lahir")
    val tanggalLahir: String,
    @field:SerializedName("tempat_lahir")
    val tempatLahir: String,
    @field:SerializedName("no_hp")
    val noHp: String,
    @field:SerializedName("alamat")
    val alamat: String
)
