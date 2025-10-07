package com.example.myapplication.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.presentation.navigation.Screen
import com.example.myapplication.presentation.screen.state.LoginScreenEvent
import com.example.myapplication.presentation.screen.state.LoginScreenState
import com.example.myapplication.presentation.screen.viewModel.LoginScreenViewModel
import com.example.myapplication.presentation.ui.component.StyledButton

@Composable
fun LoginScreen (
    onNavigateTo: (Screen) -> Unit
) {
    val viewModel = viewModel<LoginScreenViewModel>()
    LoginView(
        state = viewModel.state,
        onNavigateTo = onNavigateTo,
        onEvent = viewModel::onEvent,
    )
}

@Composable
fun LoginView(
    onNavigateTo: (Screen) -> Unit = {},
    state: LoginScreenState = LoginScreenState(),
    onEvent: (LoginScreenEvent) -> Unit = {}

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
        Image(
            painter = painterResource(id = R.drawable.news),
            contentDescription = "News app login i  mage",
            modifier = Modifier
                .padding(top = 30.dp)
        )

        OutlinedTextField(
            modifier = Modifier.padding(top = 50.dp),
            value = state.email,
            onValueChange = {
                onEvent(LoginScreenEvent.EmailUpdated(it))
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
                onEvent(LoginScreenEvent.PasswordUpdated(it))
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
            modifier = Modifier.padding(top = 50.dp)
        ) {
            Text(
                text = stringResource(R.string.login),
                fontSize = 19.sp,
            )
        }

        Text(
            text = stringResource(id = R.string.no_account_register),
            fontSize = 18.sp,
            modifier = Modifier
                .padding(80.dp)
                .clickable {
                    onNavigateTo(Screen.Register )
                }
        )

    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LoginScreenPreview() {
    LoginView()
}