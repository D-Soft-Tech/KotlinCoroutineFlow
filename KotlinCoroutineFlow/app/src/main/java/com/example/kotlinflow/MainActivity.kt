package com.example.kotlinflow

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.transform

class MainActivity : AppCompatActivity() {
//    private lateinit var data: ArrayList<Int>

    private lateinit var datastore: DataStore<Preferences>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        datastore = createDa

//        data = arrayListOf()
//
//        (0..1000000).forEach { data.add(it) }
//
//        lifecycleScope.launchWhenCreated {
//            sendData().buffer().filter {
//                it % 20 == 0
//            }.map {
//                it * 10
//            }.transform {
//                emit("Here is number $it")
//            }.onEach {
//                check(it.isNotEmpty())
//            }.catch { e ->
//                print("Here is the Error catched: -> $e")
//            }.onCompletion {
//                print("With or without error, this will be done at the end of the computation")
//            }.collect {
//                delay(1000L)
//                println("Here is number $it")
//            }
//        }
    }

//    fun sendData() = data.asFlow()

    private suspend fun save(key: String, value: String) {
        val dataStoreKey = stringPreferencesKey(key)
        datastore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }

    private suspend fun read(key: String) = run {
        val dataStoreKey = stringPreferencesKey(key)
        val storedValue = datastore.data.first()
        storedValue[dataStoreKey]
    } ?: "No value Stored"
}
