package com.example.hard_mad_2.screen

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.hard_mad_2.R
import com.example.hard_mad_2.common.Constant.HEADLINE_LARGE_SIZE
import com.example.hard_mad_2.common.Constant.SMALL_HEIGHT
import com.example.hard_mad_2.common.Constant.SMALL_WIDTH
import com.example.hard_mad_2.common.Constant.TITLE_LARGE_SIZE
import com.example.hard_mad_2.components.sign_in_component.AutoScrollingLazyRow
import com.example.hard_mad_2.components.sign_in_component.CustomInputField
import com.example.hard_mad_2.data_stub.Data
import com.example.hard_mad_2.state.FormState
import java.util.Locale

@Composable
fun SignInScreenContent() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    val headlineLargeSize =
        if (screenWidth < SMALL_WIDTH || screenHeight < SMALL_HEIGHT) HEADLINE_LARGE_SIZE.sp else
            MaterialTheme.typography.headlineLarge.fontSize
    val titleLargeSize =
        if (screenWidth < SMALL_WIDTH || screenHeight < SMALL_HEIGHT) TITLE_LARGE_SIZE.sp else
            MaterialTheme.typography.titleLarge.fontSize

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
                text = stringResource(R.string.open_for_yourself).uppercase(Locale.ROOT),
                style = MaterialTheme.typography.headlineLarge.copy(fontSize = headlineLargeSize),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
            Text(
                modifier = Modifier.offset(y = (-15).dp),
                text = stringResource(R.string.book_world).uppercase(Locale.ROOT),
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