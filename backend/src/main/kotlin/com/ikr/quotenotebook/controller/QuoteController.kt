package com.ikr.quotenotebook.controller

import com.ikr.quotenotebook.model.Quote
import com.ikr.quotenotebook.service.QuoteService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/quotes")
class QuoteController(private val quoteService: QuoteService) {

    @GetMapping("/daily")
    fun getDailyQuote(): Quote = quoteService.getDailyQuote()

    @GetMapping
    fun getAllQuotes(): List<Quote> = quoteService.getAllQuotes()

    @GetMapping("/{id}")
    fun getQuoteById(@PathVariable id: Long): Quote = quoteService.getQuoteById(id)

    @GetMapping("/category/{category}")
    fun getQuotesByCategory(@PathVariable category: String): List<Quote> =
        quoteService.getQuotesByCategory(category)

    @PostMapping
    fun addQuote(@RequestBody quote: Quote): Quote = quoteService.addQuote(quote)
}