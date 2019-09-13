package com.story_tail.privypics.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.story_tail.privypics.database.ImageDao
import com.story_tail.privypics.database.PrivyPicDatabase
import com.story_tail.privypics.model.Image
import javax.inject.Singleton

@Singleton
class ImageRepository(context: Context) {
    private val imageDao: ImageDao by lazy { PrivyPicDatabase.getDatabase(
        context
    ).imageDao() }

    suspend fun insertImage(image: Image) {
        imageDao.insertImage(image)
    }

    fun getAllImages(): LiveData<List<Image>> {
        return imageDao.getAllImages()
    }

    suspend fun deleteImage(image: Image) {
        imageDao.deleteImage(image)
    }

    suspend fun updateImage(image: Image) {
        imageDao.updateImage(image)
    }
}