package com.ikr.quotenotebook.model


import jakarta.persistence.*

@Entity
data class Quote(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, length = 1000)
    val text: String,

    @Column(nullable = true)
    val author: String? = null,

    @Column(nullable = false)
    val category: String,

    @ElementCollection
    val tags: List<String> = emptyList(),

    @Column(nullable = false)
    val isPreloaded: Boolean = false
)