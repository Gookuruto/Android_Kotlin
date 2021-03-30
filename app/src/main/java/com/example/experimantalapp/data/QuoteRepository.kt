package com.example.experimantalapp.data

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao) {
    fun AddQuote(quote:Quote){
        quoteDao.AddQuote(quote)
    }
    fun GetQuotes() = quoteDao.GetQuotes()

    companion object{
        @Volatile private var instance:QuoteRepository? = null

        fun GetInstance(quoteDao: FakeQuoteDao)=
            instance?: synchronized(this){
                instance?:QuoteRepository(quoteDao).also { instance = it }
            }
    }
}