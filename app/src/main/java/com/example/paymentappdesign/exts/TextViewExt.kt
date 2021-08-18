package com.example.paymentappdesign.exts

import android.content.Context
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

fun TextView?.setText(@StringRes text: Int, context: Context) {
    this?.text = context.resources.getString(text)
}