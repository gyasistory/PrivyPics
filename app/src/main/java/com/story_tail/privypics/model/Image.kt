package com.story_tail.privypics.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.util.*

@Entity(tableName = "image_table")
class Image {
    @PrimaryKey(autoGenerate = true)
    var id: UUID = UUID.randomUUID()

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB, name = "image_data")
    var data: ByteArray? = null

    @ColumnInfo(name = "image_description")
    var description: String? = null

    var dateTaken: Date? = null
}