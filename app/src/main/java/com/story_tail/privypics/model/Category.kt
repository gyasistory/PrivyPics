package com.story_tail.privypics.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "category_table", indices = [Index(value = ["name"], unique = true)])
class Category{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(typeAffinity = ColumnInfo.TEXT)
    var name: String? =null

    var priority: Int = 0
}