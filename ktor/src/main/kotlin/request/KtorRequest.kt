package org.example.request

import facility.ApiResponse
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import org.example.client.KtorClient
import org.example.facility.RequestConfig
import org.example.facility.RequestType.Companion.onMapperRequest

internal class KtorRequest(client: KtorClient) {

    private val clientRequest = client.clientKtor

    suspend inline fun <reified Response> onRequest(requestConfig: RequestConfig): ApiResponse {
        val response = clientRequest.request {
            this.url(requestConfig.url)

            requestConfig.headers?.forEach { (key, value) ->
                this.headers.append(key, value)
            }

            requestConfig.body?.let { this.setBody(it) }

            this.contentType(ContentType.parse(requestConfig.contentType))

            this.method = requestConfig.requestType.onMapperRequest()

        }

        return onProcessResponse<Response>(response)
    }

    private suspend inline fun <reified Response> onProcessResponse(response: HttpResponse): ApiResponse {
        return if (response.status.isSuccess()) {
            ApiResponse.Success(decodeJson<Response>(response.bodyAsText()), response.status.value)
        } else {
            ApiResponse.Error(response.status.value)
        }
    }

    private inline fun <reified T> decodeJson(rawContent: String): T {
        val json = Json { ignoreUnknownKeys = true }
        return json.decodeFromString(rawContent)
    }
}
