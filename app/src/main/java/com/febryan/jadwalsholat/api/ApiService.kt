package com.febryan.jadwalsholat.api

import com.febryan.jadwalsholat.model.ResponseJadwalSholat
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("format/{format}/jadwal/kota/{kode}/tanggal/{tanggal}")
    fun getJadwalSholat(@Path("format") format : String,
                        @Path("kode") kode : String,
                        @Path("tanggal") tanggal : String) : Call<ResponseJadwalSholat>

}