package com.ikr.quotenotebook.model


import jakarta.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Id
    val uid: String,

    val email: String,

    @ElementCollection
    val likedQuotes: MutableSet<Long> = mutableSetOf(),

    @ElementCollection
    val hiddenPreloadedQuotes: MutableSet<Long> = mutableSetOf()
)
