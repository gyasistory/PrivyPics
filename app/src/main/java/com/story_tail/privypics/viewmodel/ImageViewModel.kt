package com.story_tail.privypics.viewmodel

import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import com.story_tail.privypics.model.Image
import com.story_tail.privypics.repository.ImageRepository
import kotlinx.coroutines.coroutineScope as coroutineScope1

class ImageViewModel(context: Context) : ViewModel() {
    private val imageRepository by lazy { ImageRepository(context) }
    private var model: Image? = Image()

    fun setImage(image: Image?) {
        model = image
    }

    fun saveImage() {

            model?.let { coroutineScope1 {  imageRepository.insertImage(it) } }
    }

    var image: Bitmap?
        set(value) {
            model?.data = value
        }
        get() = model?.data
}