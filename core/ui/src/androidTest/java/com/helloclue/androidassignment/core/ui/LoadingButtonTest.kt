package com.helloclue.androidassignment.core.ui

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class LoadingButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun isCreated(): Unit = with(composeTestRule) {
        // Start the app
        setContent {
            AddLoadingButton(onClick = {})
        }
    }
}