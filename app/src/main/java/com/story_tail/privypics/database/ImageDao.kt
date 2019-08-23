package com.story_tail.privypics.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.story_tail.privypics.model.Image

@Dao
interface ImageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertImage(vararg image: Image)

    @Update
    fun updateImage(vararg image: Image)

    @Delete
    fun deleteImage(vararg image: Image)

    @Query("SELECT * from image_table ORDER BY dateTaken DESC")
    fun getAllImages(): LiveData<List<Image>>
}