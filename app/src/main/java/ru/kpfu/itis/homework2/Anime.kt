package ru.kpfu.itis.homework2

data class Anime(
    val id: Int,
    val name: String,
    val description: String,
    val pictureUrl: String = ""
)