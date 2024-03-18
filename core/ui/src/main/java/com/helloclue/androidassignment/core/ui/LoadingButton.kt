package com.helloclue.androidassignment.core.ui

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.helloclue.androidassigment.designsystem.ClueAaIcons

@Composable
fun AddLoadingButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = !isLoading,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(20.dp),
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        Icon(
            imageVector = ClueAaIcons.Add,
            contentDescription = "Plus",
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
        )
    }
}