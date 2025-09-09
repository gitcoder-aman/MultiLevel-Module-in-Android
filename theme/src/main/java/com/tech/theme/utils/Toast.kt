package com.tech.theme.utils

import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes

@RequiresApi(Build.VERSION_CODES.R)
fun Context.toast(
    message: String,
    onToastDisplayChange: (Boolean) -> Unit = {},
) {
    showToast(message, onToastDisplayChange)
}

@RequiresApi(Build.VERSION_CODES.R)
fun Context.toast(
    @StringRes message: Int,
    onToastDisplayChange: (Boolean) -> Unit = {},
) {
    showToast(getString(message), onToastDisplayChange)
}

@RequiresApi(Build.VERSION_CODES.R)
private fun Context.showToast(
    message: String,
    onToastDisplayChange: (Boolean) -> Unit,
) {
    Toast
        .makeText(this, message, Toast.LENGTH_SHORT)
        .also {
            it.addCallback(
                @RequiresApi(Build.VERSION_CODES.R)
                object : Toast.Callback() {
                    override fun onToastHidden() {
                        super.onToastHidden()
                        onToastDisplayChange(false)
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                        onToastDisplayChange(true)
                    }
                },
            )
        }.show()
}
