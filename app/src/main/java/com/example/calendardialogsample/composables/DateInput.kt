package com.example.calendardialogsample.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun DateInput(modifier: Modifier = Modifier) {

    Box(modifier = modifier.fillMaxWidth()) {
        var dateText by remember { mutableStateOf("") }
        var isValidDate by remember { mutableStateOf(true) }

        val focusManager = LocalFocusManager.current

        OutlinedTextField(
            value = dateText,
            onValueChange = {
                if (it.all { char -> char.isDigit() || char == '/' }) {
                    dateText = it
                }
            },
            visualTransformation = DateTransformation(),
            label = { Text("Enter Date (mm/dd/yyyy)") },
            modifier = Modifier.fillMaxWidth(),
            isError = !isValidDate,
            trailingIcon = {
                if (!isValidDate) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Error",
                        tint = Color.Red
                    )
                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (isValidDate) Color.Blue else Color.Red,
                unfocusedBorderColor = if (isValidDate) Color.LightGray else Color.Red
            )
        )

        if (!isValidDate) {
            Text(
                text = "Please enter a valid date",
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }

}

