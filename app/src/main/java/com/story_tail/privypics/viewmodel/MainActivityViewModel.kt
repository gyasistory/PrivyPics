package com.story_tail.privypics.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.story_tail.privypics.model.Category
import com.story_tail.privypics.repository.CategoryRepository
import com.story_tail.privypics.repository.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    // region repository initialization
    private val categoryRepository by lazy {
        CategoryRepository(application)
    }

    private val imageRepository by lazy {
        ImageRepository(application)
    }

    //endregion repository initialization

    //region get Data
    fun getAllCategories() : LiveData<List<Category>> {
        return categoryRepository.getAllCategorys()
    }

    //endregion get Data

    // region data editing
    fun insertCategory(category: Category) = viewModelScope.launch(Dispatchers.IO) {
        categoryRepository.insertCategory(category)
    }
    // endregion data editing
}