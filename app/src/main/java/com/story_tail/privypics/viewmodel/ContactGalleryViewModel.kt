package com.story_tail.privypics.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.story_tail.privypics.model.Category
import com.story_tail.privypics.model.Image
import com.story_tail.privypics.repository.CategoryImageRepository
import com.story_tail.privypics.repository.ImageRepository

class ContactGalleryViewModel(application: Application) : AndroidViewModel(application) {
    private val imageRepository by lazy {
        ImageRepository(application)
    }
    private val categoryImageRepository by lazy {
        CategoryImageRepository(application)
    }

    fun getByCategory(category: Category?) : LiveData<List<Image>> {
        category ?: return imageRepository.getAllImages()
        return categoryImageRepository.getImageByCategory(category)
    }
}