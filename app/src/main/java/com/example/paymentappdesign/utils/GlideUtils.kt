package com.example.paymentappdesign.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.paymentappdesign.R

object GlideUtils {

    @JvmStatic
    @BindingAdapter("imageUrl",requireAll = false)
    fun imageUrl(imageView: ImageView, url: String?) {
        if (url?.isNotEmpty() == true) {
            Glide.with(imageView.context)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .into(imageView)
        }
    }
}