package com.mokelab.lesson.core.design

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable

@Composable
fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
    )
}