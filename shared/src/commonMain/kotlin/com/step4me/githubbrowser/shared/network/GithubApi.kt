package com.step4me.githubbrowser.shared.network

import com.step4me.githubbrowser.shared.entity.User
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class GithubApi {
    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun getUser(query: String): User {
        return httpClient.get("${BASE_URL}users/$query")
    }

    companion object {
        private const val BASE_URL = "https://api.github.com/"
    }
}