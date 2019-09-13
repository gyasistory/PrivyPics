package com.story_tail.privypics.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream
import java.sql.Date
import java.util.*

class RoomTypeConverters {

    @TypeConverter
    fun fromDatetoLong(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromTimeStamp(value: Long?): Date? {
        return  if (value == null) null else Date(value)
    }

    @TypeConverter
    fun fromStringtoUUID(idString: String?): UUID {
        return UUID.fromString(idString)
    }

    @TypeConverter
    fun fromUUIDtoString(id: UUID): String {
        return id.toString()
    }

    @TypeConverter
    fun fromBytestoBitmap(array: ByteArray): Bitmap? {
        return BitmapFactory.decodeByteArray(array, 0, array.size)
    }

    @TypeConverter
    fun fromBitmaptoBytes(bitmap: Bitmap): ByteArray? {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        return stream.toByteArray()
    }
}