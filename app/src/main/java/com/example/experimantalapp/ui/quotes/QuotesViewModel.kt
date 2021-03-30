package com.example.experimantalapp.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.experimantalapp.data.Quote
import com.example.experimantalapp.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    fun GetQuotes() = quoteRepository.GetQuotes()

    fun AddQuote(quote:Quote) = quoteRepository.AddQuote(quote)
}