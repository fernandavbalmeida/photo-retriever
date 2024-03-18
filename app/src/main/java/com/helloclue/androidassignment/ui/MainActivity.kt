package com.helloclue.androidassignment.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.rememberNavController
import com.helloclue.androidassigment.designsystem.theme.ClueAaTheme
import com.helloclue.androidassignment.navigation.ClueAaNavHost
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClueAaTheme {
                val navController = rememberNavController()
                ClueAaNavHost(navController)
            }
        }
    }

}
