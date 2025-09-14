package com.tech.modularization.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech.auth.R
import com.tech.modularization.auth.AuthScreen
import com.tech.modularization.auth.domain.LoginUseCase
import com.tech.modularization.auth.domain.Resource
import com.tech.modularization.auth.domain.ResourceError
import com.tech.modularization.auth.validators.AuthParam
import com.tech.modularization.auth.validators.ValidatorFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewmodel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val validatorFactory: ValidatorFactory,
) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.NotAuthenticated())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEvent(uiEvent: LoginUiEvent) {
        when (uiEvent) {
            is LoginUiEvent.EmailChanged -> {
                updateState { it.copy(email = uiEvent.email) }
            }

            is LoginUiEvent.PasswordChanged -> {
                updateState { it.copy(email = uiEvent.password) }
            }

            is LoginUiEvent.Login -> {
                if (areInputsValid()) {
                    login()
                }
            }

            is LoginUiEvent.ForgetPassword -> {

            }

            is LoginUiEvent.Signup -> {

            }
        }
    }

    private fun updateState(update: (LoginUiState.NotAuthenticated) -> LoginUiState.NotAuthenticated) {
        _uiState.value =
            (_uiState.value as? LoginUiState.NotAuthenticated)?.let(update) ?: _uiState.value
    }

    fun areInputsValid(): Boolean {

        val ui = _uiState.value as? LoginUiState.NotAuthenticated ?: return false
        val emailError = validatorFactory.get(AuthParam.EMAIL).validate(ui.email)
        val passwordError = validatorFactory.get(AuthParam.PASSWORD).validate(ui.password)
        updateState {
            it.copy(
                emailError = emailError.errorMessage,
                passwordError = passwordError.errorMessage
            )
        }
        return emailError.isValid && passwordError.isValid
    }

    private fun login() = viewModelScope.launch {
        val ui = _uiState.value as? LoginUiState.NotAuthenticated ?: return@launch
        updateState { it.copy(isLoading = true) }
        _uiState.value = when (val loginResult = loginUseCase.invoke(ui.email, ui.password)) {
            is Resource.Success -> LoginUiState.Authenticated
            is Resource.Error -> ui.copy(loginError = getError(loginResult))
        }
    }

    private fun getError(loginError: Resource.Error): Int? {
        return when(loginError.e){
            ResourceError.UNAUTHORIZED -> R.string.invalid_email_password
            ResourceError.SERVICE_UNAVAILABLE -> "Service unavailable, please try again!"
            ResourceError.UNKNOWN -> "Unknown error, please try again later!"
        } as Int?
    }
}