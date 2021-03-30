package com.example.experimantalapp.utils

import com.example.experimantalapp.data.FakeDB
import com.example.experimantalapp.data.QuoteRepository
import com.example.experimantalapp.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory{
        val quoteRepository = QuoteRepository.GetInstance(FakeDB.GetInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}