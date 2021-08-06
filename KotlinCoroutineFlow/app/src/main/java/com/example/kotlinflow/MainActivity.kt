package com.example.kotlinflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.flow.flowOf

class MainActivity : AppCompatActivity() {
    private lateinit var data: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (0..1000000).forEach { data.add(it) }

    }

    fun sendData() = flowOf(data)
}
