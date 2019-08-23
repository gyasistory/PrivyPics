package com.story_tail.privypics.repository

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.story_tail.privypics.database.PrivyPicDatabase
import com.story_tail.privypics.model.Category
import com.story_tail.privypics.model.CategoryImage
import com.story_tail.privypics.model.Image
import javax.inject.Singleton

@Singleton
class CategoryImageRepository(context: Context) {
    private val categoryImageDao by lazy {
        PrivyPicDatabase.getDatabase(context).categoryImageDao()
    }

   fun getImageByCategory(category: Category): LiveData<List<Image>> {
        return categoryImageDao.getImagesByCategory(categoryId = category.id)
    }

    fun getCategoryByImage(image: Image): LiveData<List<Category>> {
        return categoryImageDao.getCategoryByImage(imageId = image.id)
    }

    @WorkerThread
    suspend fun insertCategoryImage(categoryImage: CategoryImage) {
        categoryImageDao.insert(categoryImage)
    }

    @WorkerThread
    suspend fun deleteCategoryImage(categoryImage: CategoryImage) {
        categoryImageDao.deleteCategoryImage(categoryImage)
    }
}