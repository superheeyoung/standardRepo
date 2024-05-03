package com.standard.multiviewtyperecyclerview.data.remote.model

import com.google.gson.annotations.SerializedName

//내가 원하는 json의 key 값만 converting 하셔도 됩니다.
data class SearchResponse(
    @SerializedName("meta") val searchMeta: MetaResponse,
    @SerializedName("documents") val searchDocuments: List<DocumentResponse>
)

data class MetaResponse(
    @SerializedName("total_count") val count: Int,
    @SerializedName("pageable_count") val pageCount: Int,
    @SerializedName("is_end") val isEnd: Boolean
)

data class DocumentResponse(
    @SerializedName("collection") val collection: String,
    @SerializedName("thumbnail_url") val thumbnailUrl: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("display_sitename") val siteName: String,
    @SerializedName("doc_url") val docUrl: String,
    @SerializedName("datetime") val dateTime: String    // Datetime
)
