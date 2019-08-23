package com.story_tail.privypics.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "category_table")
class Category{
    @PrimaryKey
    var id: UUID = UUID.randomUUID()

    @ColumnInfo(typeAffinity = ColumnInfo.TEXT)
    var name: String? =null

    var priority: Int = 0
}