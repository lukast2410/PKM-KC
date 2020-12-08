package com.example.robotyou

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val thread = Thread(){
            kotlin.run {
                try {
                    Thread.sleep(1500)
                }catch (e: InterruptedException){
                    e.printStackTrace()
                }finally {
                    startActivity(Intent(this, ChatActivity::class.java))
                    finish()
                }
            }
        }

        thread.start()
    }
}