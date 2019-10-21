package com.story_tail.privypics.utils

import android.graphics.Bitmap
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("bitmap")
fun AppCompatImageView?.setBitmap(bitmap: Bitmap?) {
    bitmap?.let { this?.setImageBitmap(it) }
}