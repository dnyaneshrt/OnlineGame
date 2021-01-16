package com.tech.onlinematka.data


data class Feed(


    val category: List<Category>,

    val link: List<Link>,

    val entry: List<Entry>
)


data class Category(
    val scheme: String,
    val term: String
)

data class Entry(

    val category: List<Category>? = null,
    val link: List<Link>? = null,

    val gsCell: GsCell? = null
)


data class GsCell(
    val row: String,
    val col: String,
    val inputValue: String,
    val t: String,

    val numericValue: String? = null
)

data class Link(
    val rel: String,
    val href: String
)

