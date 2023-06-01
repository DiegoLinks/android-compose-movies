package com.compose.movies.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.compose.movies.presentation.ui.theme.appBarTextStyle
import com.compose.movies.presentation.utils.Dimens

@Composable
fun TopAppBar(
    title: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(Dimens.spacingLarge),
            style = appBarTextStyle
        )
    }
}