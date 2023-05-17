package com.utkualtas.feature.authentication

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.utkualtas.core.ui.DevicePreviews
import com.utkualtas.core.ui.theme.CoinTickerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthenticationScreen(
    state: AuthenticationUIState,
    onMessageShown: () -> Unit,
    onEmailChange: (value: String) -> Unit,
    onPasswordChange: (value: String) -> Unit,
    onNavigateBack: () -> Unit,
    onNavigateHome: () -> Unit,
    onSwitchLoginRegister: () -> Unit,
    onProceed: () -> Unit,
) {
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(state.message) {
        if (state.message != null) {
            snackbarHostState.showSnackbar(state.message)
            onMessageShown()
        }
    }

    BackHandler(true) {
        onNavigateHome()
    }

    LaunchedEffect(state.navigateBack) {
        if (state.navigateBack) onNavigateBack()
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier.padding(bottom = 48.dp),
                text = state.title,
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Email") },
                value = state.email,
                onValueChange = onEmailChange
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                label = { Text("Password") },
                value = state.password,
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = onPasswordChange
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 36.dp),
                shape = MaterialTheme.shapes.small,
                onClick = onProceed
            ) {
                Text(text = state.proceedButtonTitle)
            }

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                shape = MaterialTheme.shapes.small,
                onClick = onSwitchLoginRegister
            ) {
                Text(text = state.switchButtonTitle)
            }

        }
    }
    SnackbarHost(hostState = snackbarHostState)
}

@DevicePreviews
@Composable
private fun AuthenticationScreenPreview() {
    CoinTickerTheme {
        val state = AuthenticationUIState()
        AuthenticationScreen(
            state = state,
            onMessageShown = {},
            onEmailChange = {},
            onPasswordChange = {},
            onNavigateBack = {},
            onNavigateHome = {},
            onSwitchLoginRegister = {},
            onProceed = {},
        )
    }
}