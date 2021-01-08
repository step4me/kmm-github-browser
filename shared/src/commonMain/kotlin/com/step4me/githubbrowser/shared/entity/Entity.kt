package com.step4me.githubbrowser.shared.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
        @SerialName("login")
        val login: String,
        @SerialName("avatar_url")
        val avatarUrl: String?,
        @SerialName("name")
        val name: String?,
        @SerialName("company")
        val company: String?,
        @SerialName("repos_url")
        val reposUrl: String?,
        @SerialName("blog")
        val blog: String?
)