package com.tech.auth.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.tech.auth.R
import com.tech.theme.AppTheme
import com.tech.theme.component.AppPreview

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    Splash()
}

@Composable
fun Splash() {
    // TODO: implement Splash composable
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.note_app),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}

@AppPreview
@Composable
fun SplashPreview() {
    AppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Splash()
        }
    }
}