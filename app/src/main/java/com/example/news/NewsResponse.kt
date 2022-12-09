package com.example.news

data class NewsResponse (
    val status: String? = null,
    val totalResults: Long? = null,
    val articles: List<Article>? = null
)

data class Article (
    val source: Source? = null,
    val author: String? = null,
    val title: String? = null,
    val description: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
    val publishedAt: String? = null,
    val content: String? = null
)

data class Source (
    val id: String? = null,
    val name: String? = null
)
