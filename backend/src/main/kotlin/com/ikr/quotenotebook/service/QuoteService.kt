package com.ikr.quotenotebook.service


import com.ikr.quotenotebook.model.Quote
import com.ikr.quotenotebook.repository.QuoteRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QuoteService(private val quoteRepository: QuoteRepository) {

    fun getDailyQuote(): Quote {
        // Later you can use user preferences; now just return the first one
        return quoteRepository.findAll().random()
    }

    fun getAllQuotes(): List<Quote> = quoteRepository.findAll()

    fun getQuoteById(id: Long): Quote =
        quoteRepository.findById(id).orElseThrow { NoSuchElementException("Quote not found") }

    fun getQuotesByCategory(category: String): List<Quote> =
        quoteRepository.findByCategory(category)

    fun addQuote(quote: Quote): Quote = quoteRepository.save(quote)
}
