package com.tumusx.multiplatform.data.repository

import com.tumusx.multiplatform.data.model.Post
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class PostRepositoryImpl : PostRepository {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }
    }

    override suspend fun getPosts(): Result<List<Post>> {
        return try {
            val posts = client.get("https://jsonplaceholder.typicode.com/posts").body<List<Post>>()
            Result.success(posts)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
