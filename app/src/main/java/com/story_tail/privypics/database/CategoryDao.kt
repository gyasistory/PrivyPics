package com.story_tail.privypics.database

import androidx.room.*
import com.story_tail.privypics.model.Category

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(vararg category: Category)

    @Update
    fun updateCategory(vararg category: Category)

    @Delete
    fun deleteCategory(vararg category: Category)

    @Query("SELECT * from category_table ORDER BY name DESC")
    fun getAllCategorys(): List<Category>
}