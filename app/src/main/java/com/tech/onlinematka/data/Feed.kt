package com.tech.onlinematka.data


import com.beust.klaxon.*

private fun <T> Klaxon.convert(k: kotlin.reflect.KClass<*>, fromJson: (JsonValue) -> T, toJson: (T) -> String, isUnion: Boolean = false) =
    this.converter(object: Converter {
        @Suppress("UNCHECKED_CAST")
        override fun toJson(value: Any)        = toJson(value as T)
        override fun fromJson(jv: JsonValue)   = fromJson(jv) as Any
        override fun canConvert(cls: Class<*>) = cls == k.java || (isUnion && cls.superclass == k.java)
    })

private val klaxon = Klaxon()
    .convert(TitleType::class, { TitleType.fromValue(it.string!!) }, { "\"${it.value}\"" })
    .convert(LinkType::class,  { LinkType.fromValue(it.string!!) },  { "\"${it.value}\"" })

data class Welcome6 (
    val version: String,
    val encoding: String,
    val feed: Feed
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<Welcome6>(json)
    }
}

data class Feed (
    val xmlns: String,

    @Json(name = "xmlns\$openSearch")
    val xmlnsOpenSearch: String,

    @Json(name = "xmlns\$batch")
    val xmlnsBatch: String,

    @Json(name = "xmlns\$gs")
    val xmlnsGs: String,

    val id: GsColCount,
    val updated: GsColCount,
    val category: List<Category>,
    val title: Title,
    val link: List<Link>,
    val author: List<Author>,

    @Json(name = "openSearch\$totalResults")
    val openSearchTotalResults: GsColCount,

    @Json(name = "openSearch\$startIndex")
    val openSearchStartIndex: GsColCount,

    @Json(name = "gs\$rowCount")
    val gsRowCount: GsColCount,

    @Json(name = "gs\$colCount")
    val gsColCount: GsColCount,

    val entry: List<Entry>
)

data class Author (
    val name: GsColCount,
    val email: GsColCount
)

data class GsColCount (
    @Json(name = "\$t")
    val t: String
)

data class Category (
    val scheme: String,
    val term: String
)

data class Entry (
    val id: GsColCount,
    val updated: GsColCount,
    val category: List<Category>,
    val title: Title,
    val content: Title,
    val link: List<Link>,

    @Json(name = "gs\$cell")
    val gsCell: GsCell
)

data class Title (
    val type: TitleType,

    @Json(name = "\$t")
    val t: String
)

enum class TitleType(val value: String) {
    Text("text");

    companion object {
        public fun fromValue(value: String): TitleType = when (value) {
            "text" -> Text
            else   -> throw IllegalArgumentException()
        }
    }
}

data class GsCell (
    val row: String,
    val col: String,
    val inputValue: String,

    @Json(name = "\$t")
    val t: String,

    val numericValue: String? = null
)

data class Link (
    val rel: String,
    val type: LinkType,
    val href: String
)

enum class LinkType(val value: String) {
    ApplicationAtomXML("application/atom+xml");

    companion object {
        public fun fromValue(value: String): LinkType = when (value) {
            "application/atom+xml" -> ApplicationAtomXML
            else                   -> throw IllegalArgumentException()
        }
    }
}
