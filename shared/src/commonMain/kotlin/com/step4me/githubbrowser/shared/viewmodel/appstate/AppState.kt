package com.step4me.githubbrowser.shared.viewmodel.appstate

import com.step4me.githubbrowser.shared.entity.User

data class AppState(
    val isLoading: Boolean = false,
    val user: User? = null
)