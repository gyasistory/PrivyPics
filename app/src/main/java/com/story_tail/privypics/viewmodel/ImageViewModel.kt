package com.story_tail.privypics.viewmodel

import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.story_tail.privypics.model.Image
import com.story_tail.privypics.repository.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class ImageViewModel(context: Context) : ViewModel() {
    private val imageRepository by lazy { ImageRepository(context) }
    private var model = MutableLiveData<Image>()

    fun setImage(image: Image?) {
        model.value = image
    }

    fun saveImage() {
        model.value?.let {
            GlobalScope.launch(Dispatchers.IO) {
                imageRepository.insertImage(it)
            }
        }
    }

    var image: Bitmap?
        get() = model.value?.data
        set(value) {
            model.value?.let {
                it.data = value
                return
            }
            val image = createImage()
            image.data = value
            model.value = image
        }

    var description = model.value?.description

    private fun createImage(): Image {
        val image = Image()
        image.id = UUID.randomUUID()
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            image.dateTaken = Date.from(Instant.now()) as Date?
//        }
        return image
    }
}