package com.example.experimantalapp.data

class FakeDB private constructor() {
    var quoteDao = FakeQuoteDao()
        private set

    companion object{
        @Volatile private var instance: FakeDB? = null

        fun GetInstance() =
            instance ?: synchronized(this){
                instance?: FakeDB().also { instance = it }
            }
    }
}