package com.example.myapplication.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.myapplication.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.presentation.navigation.Screen
import com.example.myapplication.presentation.screen.state.RegisterScreenEvent
import com.example.myapplication.presentation.screen.state.RegisterScreenState
import com.example.myapplication.presentation.screen.viewModel.RegisterScreenViewModel
import com.example.myapplication.presentation.ui.component.StyledButton

@Composable
fun RegisterScreen(
    onNavigateTo: (Screen) -> Unit = {}
) {
    val viewModel = viewModel<RegisterScreenViewModel>()
    RegisterView(
        state = viewModel.state,
        onEvent = viewModel::onEvent,
        onNavigateTo = onNavigateTo
    )
}

@Composable
fun RegisterView(
    state: RegisterScreenState = RegisterScreenState(),
    onEvent: (RegisterScreenEvent) -> Unit = {},
    onNavigateTo: (Screen) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 40.sp,
            modifier = Modifier
                .padding(top = 100.dp)
        )

        OutlinedTextField(
            modifier = Modifier.padding(top = 130.dp),
            value = state.username,
            onValueChange = {
                onEvent(RegisterScreenEvent.UsernameUpdated(it))
            },
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Person),
                    contentDescription = "null",

                    )
            },
            placeholder = {
                Text(text = stringResource(R.string.enter_username))
            },
        )

        OutlinedTextField(
            modifier = Modifier.padding(top = 10.dp),
            value = state.email,
            onValueChange = {
                onEvent(RegisterScreenEvent.EmailUpdated(it))
            },
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Email),
                    contentDescription = "null",

                    )
            },
            placeholder = {
                Text(text = stringResource(R.string.enter_email))
            },
        )

        OutlinedTextField(
            modifier = Modifier.padding(top = 10.dp),
            value = state.password,
            onValueChange = {
                onEvent(RegisterScreenEvent.PasswordUpdated(it))
            },
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Lock),
                    contentDescription = "null",
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            placeholder = {
                Text(text = stringResource(R.string.enter_password))
            },
        )

        StyledButton(
            onClick = {},
            modifier = Modifier.padding(top = 80.dp)
        ) {
            Text(
                text = stringResource(R.string.register),
                fontSize = 19.sp,
            )
        }

        Text(
            text = stringResource(id = R.string.already_have_an_account),
            fontSize = 18.sp,
            modifier = Modifier
                .padding(80.dp)
                .clickable {
                    onNavigateTo(Screen.Login )
                }
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LoginRegisterScreenPreview() {
    RegisterView()
}