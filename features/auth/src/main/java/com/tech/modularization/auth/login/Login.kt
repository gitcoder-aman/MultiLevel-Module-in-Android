package com.tech.modularization.auth.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tech.auth.R
import com.tech.theme.AppTheme
import com.tech.theme.component.AppPreview
import com.tech.theme.component.AppTextField

@Composable
fun LoginScreen(loginViewmodel: LoginViewmodel) {

    val uiState =  loginViewmodel.uiState.collectAsStateWithLifecycle()

    Login(
        uiState = uiState.value,
        onEvent = {
            loginViewmodel.onEvent(it)
        }
    )
}

@Composable
fun Login(
    uiState : LoginUiState,
    onEvent: (LoginUiEvent) ->Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Icon(
            painter = painterResource(id = R.drawable.note_app),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 42.dp, bottom = 32.dp)
        )
        AppTextField(
            value = uiState.email,
            onValueChange = {
                onEvent(LoginUiEvent.EmailChanged(it))
            },
            hint = "yourname@domain.com",
            leadingIcon = Icons.Filled.Email,
            imeAction = ImeAction.Next,
            label = R.string.email,
        )
        AppTextField(
            value = uiState.password,
            onValueChange = {
                onEvent(LoginUiEvent.PasswordChanged(it))
            },
            hint = "yourname@domain.com",
            leadingIcon = Icons.Filled.Lock,
            imeAction = ImeAction.Done,
            isPasswordField = true,
            label = R.string.password,
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(id = R.string.forgot_password),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = stringResource(id = R.string.click_here_to_reset),
                    style = MaterialTheme.typography.bodySmall
                )
            }


            Button(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowForward,
                    contentDescription = "login"
                )
            }
        }

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 64.dp)
                        .clickable {

                        },
                    text = stringResource(R.string.dont_have_account),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 64.dp),
                    text = stringResource(R.string.agree_to_term),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
            }


}

@AppPreview
@Composable
fun LoginPreview() {
    AppTheme {
        Surface {
            Login(
                uiState = LoginUiState(),
                onEvent = {}
            )
        }
    }
}