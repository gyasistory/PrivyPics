package com.story_tail.privypics.database

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.story_tail.privypics.model.Category
import javax.inject.Singleton

@Singleton
class CategoryRepository(context: Context) {
    private val categoryDao: CategoryDao by lazy {
        PrivyPicDatabase.getDatabase(context).categoryDao()
    }

    @WorkerThread
    suspend fun insertCategory(category: Category) {
        categoryDao.insertCategory(category)
    }

    fun getAllCategorys(): LiveData<List<Category>> {
        return categoryDao.getAllCategorys()
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