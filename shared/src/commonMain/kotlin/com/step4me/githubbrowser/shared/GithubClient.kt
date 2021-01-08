package com.step4me.githubbrowser.shared

import com.step4me.githubbrowser.shared.entity.User
import com.step4me.githubbrowser.shared.network.GithubApi

class GithubClient {
    private val api = GithubApi()

    suspend fun getUser(query: String): User {
        // TODO cache
        return api.getUser(query)
    }
}