package com.example.hard_mad_2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.example.hard_mad_2.components.AutoScrollingLazyRow
import com.example.hard_mad_2.data_stub.Data
import com.example.hard_mad_2.state.FormState
import com.example.hard_mad_2.ui.theme.HARD_MAD_2Theme
import java.util.Locale

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HARD_MAD_2Theme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    NavigationScreen(navController = navController, modifier = Modifier)
                }
            }
        }
    }
}


@Composable
fun SignInScreen() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    val headlineLargeSize =
        if (screenWidth < 360 || screenHeight < 740) 24.sp else MaterialTheme.typography.headlineLarge.fontSize
    val titleLargeSize =
        if (screenWidth < 360 || screenHeight < 740) 68.sp else MaterialTheme.typography.titleLarge.fontSize
    var formState by remember { mutableStateOf(FormState()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(Modifier.height(48.dp))
        AutoScrollingLazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            list = Data.signInPics,
            itemContent = { item ->
                AsyncImage(
                    model = item,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                )
            }
        )
        Spacer(Modifier.height(48.dp))
        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
            Text(
                text = stringResource(R.string.open_for_yourself).toUpperCase(Locale.ROOT),
                style = MaterialTheme.typography.headlineLarge.copy(fontSize = headlineLargeSize),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
            Text(
                modifier = Modifier.offset(y = (-20).dp),
                text = stringResource(R.string.book_world).toUpperCase(Locale.ROOT),
                style = MaterialTheme.typography.titleLarge.copy(fontSize = titleLargeSize),
                color = MaterialTheme.colorScheme.secondary
            )
            CustomInputField(
                formState.email,
                onChange = { newValue -> formState = formState.copy(email = newValue) },
                icon = R.drawable.close_icon,
                label = stringResource(R.string.email),
                isPasswordInput = false,
                validateForm = {
                    formState =
                        formState.copy(
                            isValid = formState.email.isNotEmpty()
                                    && formState.password.isNotEmpty()
                        )
                }
            )
            Spacer(Modifier.height(8.dp))
            CustomInputField(
                formState.password,
                onChange = { newValue -> formState = formState.copy(password = newValue) },
                icon = R.drawable.eye_off_icon,
                label = stringResource(R.string.password),
                isPasswordInput = true,
                validateForm = {
                    formState =
                        formState.copy(
                            isValid = formState.email.isNotEmpty()
                                    && formState.password.isNotEmpty()
                        )
                }
            )
            Button(
                onClick = { TODO() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 0.dp)
                    .offset(y = 0.dp),
                shape = RoundedCornerShape(50),
                colors = if (formState.isValid) ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onBackground) else
                    ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onPrimary
                    ),
                contentPadding = PaddingValues(15.dp)
            ) {
                Text(
                    text = stringResource(R.string.entrance),
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = if (formState.isValid) MaterialTheme.colorScheme.primary else
                        MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}


@Composable
fun CustomInputField(
    value: String,
    onChange: (String) -> Unit,
    validateForm: () -> Unit,
    icon: Int,
    label: String,
    isPasswordInput: Boolean
) {
    var passwordVisibility by remember { mutableStateOf(!isPasswordInput) }

    OutlinedTextField(
        value = value,
        onValueChange = {
            onChange(it)
            validateForm()
        },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        placeholder = { Text(label, style = MaterialTheme.typography.bodySmall) },
        textStyle = MaterialTheme.typography.bodySmall,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = getTextFieldColors(),
        visualTransformation = getVisualTransformation(isPasswordInput, passwordVisibility),
        trailingIcon = {
            TrailingIcon(
                passwordVisibility = passwordVisibility,
                icon = icon,
                onIconClick = {
                    if (isPasswordInput) {
                        passwordVisibility = !passwordVisibility
                    } else {
                        onChange("")
                    }
                }
            )
        }
    )
}

@Composable
private fun getTextFieldColors() = OutlinedTextFieldDefaults.colors(
    focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
    unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
    unfocusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary,
    focusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary,
    cursorColor = MaterialTheme.colorScheme.onPrimary,
    focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
    unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer
)

@Composable
private fun getVisualTransformation(
    isPasswordInput: Boolean,
    passwordVisibility: Boolean
): VisualTransformation {
    return if (isPasswordInput && !passwordVisibility) {
        PasswordVisualTransformation()
    } else {
        VisualTransformation.None
    }
}

@Composable
private fun TrailingIcon(
    passwordVisibility: Boolean,
    icon: Int,
    onIconClick: () -> Unit
) {
    val iconRes = if (passwordVisibility) {
        painterResource(icon)
    } else {
        painterResource(R.drawable.eye_on_icon)
    }

    Icon(
        painter = iconRes,
        contentDescription = null,
        tint = MaterialTheme.colorScheme.onPrimaryContainer,
        modifier = Modifier.clickable(onClick = onIconClick)
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.primary
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HARD_MAD_2Theme {
        Greeting("Android")
    }
}