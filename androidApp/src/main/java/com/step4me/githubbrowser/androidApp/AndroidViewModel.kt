package com.step4me.githubbrowser.androidApp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.step4me.githubbrowser.shared.entity.User
import com.step4me.githubbrowser.shared.viewmodel.AppViewModel
import com.step4me.githubbrowser.shared.viewmodel.events.searchUser
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AndroidViewModel: ViewModel() {
    private val sharedModel = AppViewModel()

    @ExperimentalCoroutinesApi
    fun searchUser(query: String, onEnd: (user: User) -> Unit) {
        sharedModel.searchUser(query)
        viewModelScope.launch {
            sharedModel.stateFlow.collect {
                it.user?.let(onEnd)
            }
        }
    }
}