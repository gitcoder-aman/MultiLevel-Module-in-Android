package com.tech.modularization.auth.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.tech.auth.R
import com.tech.modularization.auth.AuthScreen
import com.tech.theme.AppTheme
import com.tech.theme.component.AppPreview

@Composable
fun SplashScreen(
    splashViewModel: SplashViewModel,
    navController: NavController,
    onAuthSuccess: () -> Unit,
) {
    val uiState = splashViewModel.uiState.collectAsStateWithLifecycle()
    when(val state = uiState.value){
        is SplashUiState.Splash -> {
            if(state.moveToLogin){
                LaunchedEffect(Unit) {
                    navController.navigate(AuthScreen.Login.route){
                        popUpTo(AuthScreen.Splash.route){
                            inclusive = true
                        }
                    }
                }
            }else{
                Splash()
            }
        }
        SplashUiState.Authenticated -> {
            LaunchedEffect(Unit) {
                onAuthSuccess()
            }
        }
    }
}

@Composable
fun Splash() {

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