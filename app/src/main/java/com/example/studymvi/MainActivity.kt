package com.example.studymvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            //todo 화면구성

            //Result
            //정확한 MVI 는 리엑트를 공부해봐야 할것 같으며
            //내 생각엔 MVVM 에서 State 로 바꾸고
            //State 의 value 값이 바뀌면
            //recompose 가 일어나는걸 활용해서
            //화면을 변화하는 패턴으로 인식된다.

            //progress visibility
            if (mainViewModel.state.isLoading) {

            } else {

            }

            //Error 발생시.
            mainViewModel.state.error?.let {

            }

            //성공시
            mainViewModel.state.success?.let {

            }

        }

    }
}