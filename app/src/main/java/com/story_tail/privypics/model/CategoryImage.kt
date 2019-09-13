package com.story_tail.privypics.model

import androidx.room.Entity
import androidx.room.ForeignKey
import java.util.*

@Entity(
    tableName = "category_image_join_table",
    primaryKeys = ["imageId", "categoryId"],
    foreignKeys = [ForeignKey(
        entity = Image::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("imageId")
    ), ForeignKey(
        entity = Category::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("categoryId")
    )]
)
class CategoryImage(val imageId: UUID, val categoryId: Int)
