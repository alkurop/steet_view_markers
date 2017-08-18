package com.alkurop.mystreetplaces.ui.home

interface Searchable {
    fun onSearch(topic: SearchTopic, query: String)
}

enum class SearchTopic {
    MAP
}