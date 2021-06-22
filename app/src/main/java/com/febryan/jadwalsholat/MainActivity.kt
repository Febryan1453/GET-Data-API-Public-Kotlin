package com.febryan.jadwalsholat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.febryan.jadwalsholat.api.ApiConfig
import com.febryan.jadwalsholat.model.ResponseJadwalSholat
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            ApiConfig.getService().getJadwalSholat("json", "667", "2021-03-25").enqueue(object : Callback<ResponseJadwalSholat>{
                override fun onResponse(call: Call<ResponseJadwalSholat>, response: Response<ResponseJadwalSholat>) {
                    if (response.isSuccessful){
                        val responseJadwalSholat = response.body()
                        val jadwal = responseJadwalSholat?.jadwal
                        val data = jadwal?.data

                        tv_subuh.text = data?.subuh
                        tv_dhuha.text = data?.dhuha
                        tv_terbit.text = data?.terbit
                        tv_dzuhur.text = data?.dzuhur
                        tv_ashar.text = data?.ashar
                        tv_magrib.text = data?.maghrib
                        tv_isya.text = data?.isya

                    }
                }
                override fun onFailure(call: Call<ResponseJadwalSholat>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            })
    }
}