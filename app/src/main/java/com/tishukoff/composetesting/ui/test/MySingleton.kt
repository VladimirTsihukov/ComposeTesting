package com.tishukoff.composetesting.ui.test

import android.util.Log
import com.tishukoff.composetesting.TAG_LOG


object MySingleton {
    init {
        Log.d(TAG_LOG, "MySingleton is initialized")
    }

    private const val data: String = "Some data"

    fun doSomething() {
        Log.d(TAG_LOG, "Doing something: $data")
    }
}