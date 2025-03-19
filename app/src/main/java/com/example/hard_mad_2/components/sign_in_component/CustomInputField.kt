package com.example.hard_mad_2.components.sign_in_component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.hard_mad_2.R


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