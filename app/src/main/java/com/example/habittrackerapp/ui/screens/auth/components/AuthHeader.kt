package com.example.habittrackerapp.ui.screens.auth.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habittrackerapp.ui.theme.Blue

@Composable
fun AuthHeader(
    title: String,
    subtitle: String,
    onBackClick: () -> Unit
) {
    Spacer(modifier = Modifier.height(16.dp))

    IconButton(
        onClick = onBackClick,
        modifier = Modifier.size(48.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            tint = Color.Gray
        )
    }

    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = title,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Blue,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = subtitle,
            fontSize = 18.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun AuthHeaderPreview() {
    AuthHeader(
        title = "Login",
        subtitle = "Enter your email and password",
        onBackClick = {}
    )
}
