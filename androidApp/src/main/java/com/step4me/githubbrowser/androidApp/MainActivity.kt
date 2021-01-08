package com.step4me.githubbrowser.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.step4me.githubbrowser.shared.GithubClient
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val mainScope = MainScope()
    private val apiClient = GithubClient()
    // TODO 직접 입력받는 형태로 수정
    private val testKeyword = "step4me"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Github Browser"
        setContentView(R.layout.activity_main)
        searchUser(testKeyword)
    }

    override fun onDestroy() {
        mainScope.cancel()
        super.onDestroy()
    }

    private fun searchUser(query: String) {
        mainScope.launch {
            kotlin.runCatching {
                apiClient.getUser(query)
            }.onSuccess {
                Log.i("user info", "name=${it.name}, blog=${it.blog}")
            }.onFailure {
                Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
