package com.story_tail.privypics.viewmodel

import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.story_tail.privypics.model.Image
import com.story_tail.privypics.repository.ImageRepository
import kotlinx.coroutines.launch
import java.util.*

class ImageViewModel(context: Context) : ViewModel() {
    private val imageRepository by lazy { ImageRepository(context) }
    private var model = MutableLiveData<Image>()

    fun setImage(image: Image?) {
        model.value = image
    }

    fun saveImage() {
        viewModelScope.launch {
            model.value?.let { imageRepository.insertImage(it) }
        }

    }

    var image: Bitmap?
        set(value) {
            model.value?.let {
                it.data = value
                return
            }
            val image = createImage()
            image.data = value
            model.value = image
        }
        get() = model.value?.data

    private fun createImage(): Image {
        val image = Image()
        image.id = UUID.randomUUID()
        return image
    }
}