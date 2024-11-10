package org.example

import kotlinx.serialization.Serializable
import org.example.client.CustomClientKtor
import org.example.client.KtorClient
import org.example.facility.RequestConfig
import org.example.facility.RequestType
import org.example.request.KtorRequest

suspend fun main() {

    val ktorClient: KtorClient = CustomClientKtor()

    val ktorRequest = KtorRequest(ktorClient)

    val result = ktorRequest.onRequest<List<Cats>>(
        requestConfig = RequestConfig(
            requestType = RequestType.Get,
            headers = null,
            body = null,
            url = "https://api.thecatapi.com/v1/images/search",
            contentType = "application/json"
        )
    )

    println("\nRequisição\n\n\n$result")

}

@Serializable
internal data class Cats(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int
)
