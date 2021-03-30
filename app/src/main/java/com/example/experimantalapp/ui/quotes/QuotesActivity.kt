package com.example.experimantalapp.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.experimantalapp.R
import com.example.experimantalapp.data.Quote
import com.example.experimantalapp.databinding.ActivityQuotesBinding
import com.example.experimantalapp.utils.InjectorUtils
import java.lang.StringBuilder

class QuotesActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityQuotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeUi(binding)
    }

    private fun initializeUi(binding: ActivityQuotesBinding){
        val factory = InjectorUtils.provideQuotesViewModelFactory()

        val viewModel = ViewModelProviders.of(this,factory)
            .get(QuotesViewModel::class.java)

        viewModel.GetQuotes().observe(this, Observer { quotes ->
        val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            binding.textViewQuotes.text = stringBuilder.toString()
        })

        binding.buttonAddQuote.setOnClickListener{
            val quote = Quote(binding.editTextQuote.text.toString(), binding.editTextAuthor.text.toString())
            viewModel.AddQuote(quote)
            binding.editTextQuote.setText("")
            binding.editTextAuthor.setText("")
        }
    }
}