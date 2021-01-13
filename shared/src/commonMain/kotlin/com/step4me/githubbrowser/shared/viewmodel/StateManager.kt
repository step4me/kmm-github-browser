package com.step4me.githubbrowser.shared.viewmodel

import com.step4me.githubbrowser.shared.GithubClient
import com.step4me.githubbrowser.shared.viewmodel.appstate.AppState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow

class StateManager {

    @ExperimentalCoroutinesApi
    internal val mutableStateFlow = MutableStateFlow(AppState())

    @ExperimentalCoroutinesApi
    internal var state: AppState
        get() = mutableStateFlow.value
        set(value) { mutableStateFlow.value = value }

    internal val apiClient by lazy { GithubClient() }
}