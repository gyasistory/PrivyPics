package com.story_tail.privypics.repository

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.story_tail.privypics.database.CategoryDao
import com.story_tail.privypics.database.PrivyPicDatabase
import com.story_tail.privypics.model.Category

class CategoryRepository(context: Context) {
    private val categoryDao: CategoryDao by lazy {
        PrivyPicDatabase.getDatabase(context).categoryDao()
    }

    @WorkerThread
    suspend fun insertCategory(category: Category) {
        categoryDao.insertCategory(category)
    }

    fun getAllCategorys(): LiveData<List<Category>> {
        return categoryDao.getAllCategories()
    }

    @WorkerThread
    suspend fun deleteCategory(category: Category) {
        categoryDao.deleteCategory(category)
    }

    @WorkerThread
    suspend fun updateCategory(category: Category) {
        categoryDao.updateCategory(category)
    }
}