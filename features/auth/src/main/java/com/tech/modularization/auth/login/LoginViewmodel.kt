package com.tech.modularization.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech.modularization.auth.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewmodel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState : StateFlow<LoginUiState> = _uiState

    fun onEvent(uiEvent: LoginUiEvent){
        when(uiEvent) {
            is LoginUiEvent.EmailChanged -> {
                _uiState.value = _uiState.value.copy(email = uiEvent.email)
            }
            is LoginUiEvent.PasswordChanged -> {
                _uiState.value = _uiState.value.copy(password = uiEvent.password)
            }
            is LoginUiEvent.Login -> {
                login()
            }
            is LoginUiEvent.ForgetPassword -> {

            }
            is LoginUiEvent.Signup -> {

            }
        }
    }
    fun login() = viewModelScope.launch {
        loginUseCase.invoke(_uiState.value.email,_uiState.value.password)
    }
}