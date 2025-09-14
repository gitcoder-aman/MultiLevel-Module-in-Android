package com.tech.modularization.auth.splash

sealed class SplashUiState{
    data object Authenticated : SplashUiState()
    data class Splash(
        val isLoading : Boolean = false,
        val moveToLogin : Boolean = false
    ) : SplashUiState()
}
