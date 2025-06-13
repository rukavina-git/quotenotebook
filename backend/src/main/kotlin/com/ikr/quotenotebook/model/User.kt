package com.ikr.quotenotebook.model


import jakarta.persistence.*

@Entity
data class User(
    @Id
    val uid: String,  // Firebase UID as primary key

    val email: String,

    @ElementCollection
    val likedQuotes: MutableSet<Long> = mutableSetOf(),

    @ElementCollection
    val hiddenPreloadedQuotes: MutableSet<Long> = mutableSetOf()
)
