package com.example.isabella_infocovidapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.isabella_infocovidapp.R
import com.example.isabella_infocovidapp.api.RetrofitClient
import com.example.isabella_infocovidapp.model.IndonesiaResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showIndonesia()

        btnProvince.setOnClickListener{
            Intent(this@MainActivity, ProvinceActivity::class.java).also{
                startActivity(it)
            }
        }
    }

    private fun showIndonesia(){
        RetrofitClient.instance.getIndonesia().enqueue(
            object: Callback<ArrayList<IndonesiaResponse>> {
                override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "${t.message}", android.widget.Toast.LENGTH_SHORT).show()
            }
                override fun onResponse(
                    call: Call<ArrayList<IndonesiaResponse>>,
                    response: Response<ArrayList<IndonesiaResponse>>
                ) {
                    val Indonesia = response.body()?.get(0)
                    val positive = Indonesia?.positif
                    val hospitilized = Indonesia?.dirawat
                    val recover = Indonesia?.sembuh
                    val death = Indonesia?.meninggal

                    tvPositive.text = positive
                    tvHospitalized.text = hospitilized
                    tvRecover.text = recover
                    tvDeath.text = death
                }



            })
    }
}