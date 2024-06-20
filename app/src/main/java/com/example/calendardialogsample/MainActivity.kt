package com.example.calendardialogsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calendardialogsample.composables.DialogComposable
import com.example.calendardialogsample.ui.theme.CalendarDialogSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalendarDialogSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) =
    Column(modifier = modifier.fillMaxWidth()) {
        var shouldShowDialog by remember { mutableStateOf(false) } // 1

        val onDismissRequest: () -> Unit = {
            shouldShowDialog = shouldShowDialog.not()
        }

        if (shouldShowDialog) {
            DialogComposable(
                onDismissRequest = { shouldShowDialog = shouldShowDialog.not() },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(
            onClick = onDismissRequest,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Show Dialog")
        }
    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() = CalendarDialogSampleTheme {
    Greeting("Android")
}
