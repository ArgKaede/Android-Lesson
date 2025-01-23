package com.mokelab.lesson.core.design.theme

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mokelab.lesson.core.design.MediumText
import com.mokelab.lesson.core.design.SmallText

@Composable
fun TextListItem(
    headline: String,
    trailing: String,
    modifier: Modifier = Modifier,
) {
    ListItem(
        headlineContent = { MediumText(headline) },
        trailingContent = { SmallText(trailing) },
        modifier = modifier,
    )
    HorizontalDivider()
}