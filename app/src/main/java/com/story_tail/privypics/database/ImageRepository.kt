package com.story_tail.privypics.database

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.story_tail.privypics.model.Image
import javax.inject.Singleton

@Singleton
class ImageRepository(context: Context) {
    private val imageDao: ImageDao by lazy { PrivyPicDatabase.getDatabase(context).imageDao() }

    @WorkerThread
    suspend fun insertImage(image: Image) {
        imageDao.insertImage(image)
    }

    fun getAllImages(): LiveData<List<Image>> {
        return imageDao.getAllImages()
    }

    @WorkerThread
    suspend fun deleteImage(image: Image) {
        imageDao.deleteImage(image)
    }

    @WorkerThread
    suspend fun updateImage(image: Image) {
        imageDao.updateImage(image)
    }
}