package com.example.calendardialogsample.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.calendardialogsample.R
import com.example.calendardialogsample.ui.theme.CalendarDialogSampleTheme

data class CalendarState(
    val topContent: String? = null,
    val titleContent: String,
    @DrawableRes val iconContent: Int? = null,
    //TODO: Also add something for the initializing the input
    val leftCtaContent: String? = null,
    val rightCtaContent: String? = null,
)


@Composable
fun AlertDialogContent(
    modifier: Modifier = Modifier,
    state: CalendarState
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White),

        ) {
        val (
            topTextConst,
            titleConst,
            iconConst,
            dividerConst,
            inputCont,
            leftCta,
            rightCta,
        ) = createRefs()

        Text(
            text = state.topContent?.uppercase() ?: "",
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(topTextConst) {
                    start.linkTo(parent.start, 16.dp)
                    top.linkTo(parent.top, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    width = Dimension.fillToConstraints
                }
        )

        Text(
            text = state.titleContent,
            modifier = Modifier.constrainAs(titleConst) {
                start.linkTo(parent.start, 16.dp)
                top.linkTo(topTextConst.bottom, 16.dp)

            }
        )

        Icon(
            imageVector = Icons.Default.AccountBox,
            contentDescription = "",
            modifier = Modifier.constrainAs(iconConst) {
                top.linkTo(titleConst.top)
                end.linkTo(parent.end, 16.dp)
                bottom.linkTo(titleConst.bottom)
            }
        )

        HorizontalDivider(
            modifier = Modifier
                .constrainAs(dividerConst) {
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    top.linkTo(titleConst.bottom, 16.dp)
                    bottom.linkTo(inputCont.top, 16.dp)
                }
                .padding(horizontal = 16.dp)
        )

        DateInput(
            modifier = Modifier
                .constrainAs(inputCont) {
                    start.linkTo(parent.start, 16.dp)
                    top.linkTo(dividerConst.bottom)
                    end.linkTo(parent.end, 16.dp)
                    bottom.linkTo(parent.bottom, 16.dp)
                }
                .padding(horizontal = 16.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun PrevAlertDialogContent() = CalendarDialogSampleTheme {
    AlertDialogContent(
        state = CalendarState(
            topContent = "Date of Birth",
            titleContent = "Title Content",
            iconContent = R.drawable.ic_launcher_background,
            leftCtaContent = "Left CTA",
            rightCtaContent = "Right CTA"
        )
    )
}