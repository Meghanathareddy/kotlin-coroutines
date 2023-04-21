package com.example.assignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import org.junit.runner.Request
import java.io.IOException
import javax.security.auth.callback.Callback


class assignment()  {
    

        val url = "https://bbwmobiletest.lbidts.com/modules/v3/topnav/Home"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("API execute failed")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful){
                    val myResponse:String = response.body().toString()
                    println(myResponse)

                }

            }

        })

    }



}