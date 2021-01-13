package com.step4me.githubbrowser.shared.viewmodel

import com.step4me.githubbrowser.shared.viewmodel.appstate.AppState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow

class AppViewModel {

    @ExperimentalCoroutinesApi
    val stateFlow: StateFlow<AppState>
        get() = stateManager.mutableStateFlow

    internal val stateManager by lazy { StateManager() }
}