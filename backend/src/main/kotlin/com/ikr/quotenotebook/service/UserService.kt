package com.ikr.quotenotebook.service

import com.ikr.quotenotebook.model.Quote
import com.ikr.quotenotebook.model.User
import com.ikr.quotenotebook.repository.QuoteRepository
import com.ikr.quotenotebook.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val quoteRepository: QuoteRepository
) {

    fun getUser(uid: String): User =
        userRepository.findById(uid).orElseGet {
            val newUser = User(uid = uid, email = "")
            userRepository.save(newUser)
        }

    fun getLikedQuotes(uid: String): List<Quote> =
        quoteRepository.findAllById(getUser(uid).likedQuotes)

    fun addLikedQuote(uid: String, quoteId: Long) {
        val user = getUser(uid)
        user.likedQuotes.add(quoteId)
        userRepository.save(user)
    }

    fun removeLikedQuote(uid: String, quoteId: Long) {
        val user = getUser(uid)
        user.likedQuotes.remove(quoteId)
        userRepository.save(user)
    }

    fun getHiddenPreloadedQuotes(uid: String): List<Quote> =
        quoteRepository.findAllById(getUser(uid).hiddenPreloadedQuotes)

    fun hidePreloadedQuote(uid: String, quoteId: Long) {
        val user = getUser(uid)
        user.hiddenPreloadedQuotes.add(quoteId)
        userRepository.save(user)
    }

    fun restoreHiddenPreloadedQuotes(uid: String) {
        val user = getUser(uid)
        user.hiddenPreloadedQuotes.clear()
        userRepository.save(user)
    }
}