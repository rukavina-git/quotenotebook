package com.ikr.quotenotebook.controller

import com.ikr.quotenotebook.model.Quote
import com.ikr.quotenotebook.model.User
import com.ikr.quotenotebook.security.UserPrincipal
import com.ikr.quotenotebook.service.UserService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserController(private val userService: UserService) {

    @GetMapping("/me")
    fun getProfile(@AuthenticationPrincipal user: UserPrincipal): User {
        return userService.getUser(user.uid)
    }

    @GetMapping("/favorites")
    fun getFavorites(@AuthenticationPrincipal user: UserPrincipal): List<Quote> {
        return userService.getLikedQuotes(user.uid)
    }

}