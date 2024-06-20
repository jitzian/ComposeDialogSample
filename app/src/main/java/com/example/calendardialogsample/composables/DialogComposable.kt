@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.calendardialogsample.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.calendardialogsample.R

@Composable
fun DialogComposable(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
) {
    Box(modifier = modifier) {

        /*AlertDialog(
            properties = DialogProperties(usePlatformDefaultWidth = false),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            onDismissRequest = onDismissRequest,
            confirmButton = { },
            title = {
                Text(text = "")
            },
        )*/

        BasicAlertDialog(
            properties = DialogProperties(usePlatformDefaultWidth = false),
            onDismissRequest = onDismissRequest,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            content = {
                AlertDialogContent(
                    modifier = Modifier.fillMaxWidth(),
                    state = CalendarState(
                        topContent = "Date of Birth",
                        titleContent = "Enter Date",
                        iconContent = R.drawable.ic_launcher_background,
                        leftCtaContent = "Cancel",
                        rightCtaContent = "Ok",
                    )
                )
            }
        )
    }

}