package com.step4me.githubbrowser.shared.viewmodel.events

import com.step4me.githubbrowser.shared.viewmodel.AppViewModel
import com.step4me.githubbrowser.shared.viewmodel.statereducers.setLoading
import com.step4me.githubbrowser.shared.viewmodel.statereducers.setUser
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
fun AppViewModel.searchUser(userName: String) {
    stateManager.setLoading()
    stateManager.setUser(userName)
}