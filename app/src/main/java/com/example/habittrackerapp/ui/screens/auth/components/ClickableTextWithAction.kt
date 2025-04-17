package com.example.habittrackerapp.ui.screens.auth.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.habittrackerapp.ui.theme.Blue

@Composable
fun ClickableTextWithAction(
    mainText: String,
    actionText: String,
    actionColor: Color = Blue,
    actionStyle: SpanStyle = SpanStyle(
        color = actionColor,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline
    ),
    onClickAction: () -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium
) {
    Text(
        text = buildAnnotatedString {
            append(mainText)
            withStyle(style = actionStyle) {
                append(actionText)
            }
        },
        modifier = modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                onClickAction()
            },
        style = textStyle
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ClickableTextWithActionPreview() {
    ClickableTextWithAction(
        mainText = "Already have an account? ",
        actionText = "Login",
        onClickAction = { }
    )
}