package org.example.client

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

internal interface KtorClient {
    val clientKtor: HttpClient
}

internal class CustomClientKtor(private val timeoutConfig: Long = 3600) : KtorClient {

    override val clientKtor: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
        install(HttpTimeout) {
            requestTimeoutMillis = timeoutConfig
            socketTimeoutMillis = timeoutConfig
            connectTimeoutMillis = timeoutConfig
        }
    }
}


