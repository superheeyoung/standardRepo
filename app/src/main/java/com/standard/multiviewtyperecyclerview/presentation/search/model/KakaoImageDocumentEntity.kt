package com.standard.multiviewtyperecyclerview.presentation.search.model


data class KakaoImageListEntity(val document: List<KakaoImageDocumentEntity>)
data class KakaoImageDocumentEntity(
    val id: String,
    val title: String,
    val bookmarked: Boolean
)
