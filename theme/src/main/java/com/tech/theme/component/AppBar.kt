package com.tech.theme.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.tech.theme.AppTheme

@Composable
fun AppBar(
    title: String,
    navIcon: ImageVector?,
    onNavIconClicked: () -> Unit = {},
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(text = title)
        }, navigationIcon = {
            navIcon?.let {
                IconButton(onClick = { onNavIconClicked() }) {
                    Icon(
                        imageVector = it,
                        contentDescription = null
                    )
                }
            }
        }
    )
}

@Composable
@AppPreview
fun AppBarPreview() {
    AppTheme {
        Surface {
            AppBar(title = "Preview", navIcon = Icons.AutoMirrored.Filled.ArrowBack)
        }
    }
}
