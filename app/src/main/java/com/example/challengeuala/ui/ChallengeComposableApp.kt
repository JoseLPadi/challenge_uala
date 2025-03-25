package com.example.challengeuala.ui

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import com.example.challengeuala.ui.navigation.NavGraphComposable
import com.example.challengeuala.ui.theme.ChallengeUalaTheme


@Composable
fun ChallengeApplicationScreen(){
    ChallengeUalaTheme {
        val isPortrait = LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT
        ChallengeApplicationContent(isPortrait)
    }
}
@Composable
private fun ChallengeApplicationContent(isPortrait: Boolean) {

    NavGraphComposable(isPortrait = isPortrait)
}
