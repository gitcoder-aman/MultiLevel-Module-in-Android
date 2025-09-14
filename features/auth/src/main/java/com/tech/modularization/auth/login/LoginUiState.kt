package com.tech.modularization.auth.login

import androidx.annotation.StringRes

sealed class LoginUiState {
    data class NotAuthenticated(
        val email: String = "",
        @StringRes val emailError: Int? = null,

        val password: String = "",
        @StringRes val passwordError: Int? = null,

        val isLoading: Boolean = false,

        @StringRes val loginError: Int? = null,
    ) : LoginUiState()

    data object Authenticated : LoginUiState()
}