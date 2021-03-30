package com.example.experimantalapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    fun AddQuote(quote: Quote){
        quoteList.add(quote)

        quotes.value = quoteList
    }

    fun GetQuotes()= quotes as LiveData<List<Quote>>
}