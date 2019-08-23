package com.story_tail.privypics.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.story_tail.privypics.model.Category
import com.story_tail.privypics.model.CategoryImage
import com.story_tail.privypics.model.Image
import java.util.*

@Dao
interface CategoryImageDao {
    @Insert
    fun insert(categoryImage: CategoryImage)

    @Query("""
        SELECT * FROM image_table 
        INNER JOIN category_image_join_table
        ON image_table.id = category_image_join_table.imageId
        WHERE category_image_join_table.categoryId = :categoryId
        """)
    fun getImagesByCategory(categoryId: UUID): List<Image>

    @Query("""
        SELECT * FROM category_table
        INNER JOIN category_image_join_table
        ON category_table.id = category_image_join_table.categoryId
        WHERE category_image_join_table.categoryId = :imageId
    """)
    fun getCategoryByImage(imageId: UUID): LiveData<List<Category>>

    @Delete
    fun deleteCategoryImage(vararg categoryImage: CategoryImage)
}