package com.story_tail.privypics.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.util.*

@Entity(tableName = "image_table")
class Image {
    @PrimaryKey
    var id: UUID = UUID.randomUUID()

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB, name = "image_data")
    var data: Bitmap? = null

    @ColumnInfo(name = "image_description")
    var description: String? = null

    var dateTaken: Date? = null
}