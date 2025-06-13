package com.ikr.quotenotebook.repository


import com.ikr.quotenotebook.model.Quote
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuoteRepository : JpaRepository<Quote, Long> {
    fun findByCategory(category: String): List<Quote>
    fun findByTagsContaining(tag: String): List<Quote>
    fun findByIsPreloaded(isPreloaded: Boolean): List<Quote>
}