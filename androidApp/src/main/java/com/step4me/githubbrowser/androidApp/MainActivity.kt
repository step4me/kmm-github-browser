package com.step4me.githubbrowser.androidApp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val mainScope = MainScope()

    // TODO 직접 입력받는 형태로 수정
    private val testKeyword = "step4me"
    private val androidViewModel: AndroidViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Github Browser"
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_search).setOnClickListener(this)
    }

    override fun onDestroy() {
        mainScope.cancel()
        super.onDestroy()
    }

    @ExperimentalCoroutinesApi
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_search -> {
                androidViewModel.searchUser(testKeyword) { user ->
                    findViewById<TextView>(R.id.tv_username).text = user.name
                    findViewById<TextView>(R.id.tv_user_blog).text = user.blog
                }
            }
        }
    }
}
