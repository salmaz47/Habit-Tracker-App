package com.example.habittrackerapp.ui.components.custom_snackbar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomSnackbar(
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = {}
) {
    SnackbarHost(
        hostState = snackbarHostState,
        modifier = modifier
    ) { data ->
        Snackbar(
            modifier = Modifier.padding(16.dp),
            actionContentColor =Color.White,
            containerColor = when (data.visuals.actionLabel) {
                "Error" -> Color.Red
                "Success" -> Color(0xFF304F10)
                else -> Color.DarkGray
            },
            contentColor = Color.White,
            action = {
                data.visuals.actionLabel?.let { actionLabel ->
                    TextButton(onClick = {
                        onDismiss()
                        data.dismiss()
                    }) {
                        Text(text = actionLabel, color = Color.White)
                    }
                }
            }
        ) {
            Text(text = data.visuals.message)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CustomSnackbarPreview() {
    CustomSnackbar(snackbarHostState = SnackbarHostState())
}