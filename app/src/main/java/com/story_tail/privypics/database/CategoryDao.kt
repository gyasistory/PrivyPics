package com.story_tail.privypics.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.story_tail.privypics.model.Category

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(vararg category: Category)

    @Update
    suspend fun updateCategory(vararg category: Category)

    @Delete
    suspend fun deleteCategory(vararg category: Category)

    @Query("SELECT * from category_table ORDER BY name DESC")
    fun getAllCategories(): LiveData<List<Category>>
}