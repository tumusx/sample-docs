package org.example.facility

import io.ktor.http.*

data class RequestConfig(
    val requestType: RequestType,
    val contentType: String,
    val headers: HashMap<String, String>?,
    val body: Any? = null,
    val url: String
)

enum class RequestType {
    Get, Post, Delete, Put;

    companion object {
        internal fun RequestType.onMapperRequest(): HttpMethod {
            return HttpMethod.parse(this.name)
        }
    }
}