package com.example.isabella_infocovidapp.api

import com.example.isabella_infocovidapp.model.IndonesiaResponse
import com.example.isabella_infocovidapp.model.ProvinceResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("casenumber.json")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>

    @GET("casenumberprovince.json")
    fun getProvince(): Call<ArrayList<ProvinceResponse>>
}