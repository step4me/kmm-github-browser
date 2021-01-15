package com.step4me.githubbrowser.shared.viewmodel.statereducers

import com.step4me.githubbrowser.shared.viewmodel.StateManager
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
fun StateManager.setLoading() {
    state = state.copy(isLoading = true)
}

@ExperimentalCoroutinesApi
fun StateManager.setUser(userName: String) {
    GlobalScope.launch {
        kotlin.runCatching {
            apiClient.getUser(userName)
        }.onSuccess {
            state = state.copy(user = it)
            println("user name=${it.name}, blog=${it.blog}")
        }.onFailure {
            println("error=${it.message}")
        }
    }
}