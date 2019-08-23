package com.story_tail.privypics.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.story_tail.privypics.model.Category
import com.story_tail.privypics.model.CategoryImage
import com.story_tail.privypics.model.Image
import com.story_tail.privypics.utils.RoomTypeConverters

@Database(entities = [
    Image::class,
    Category::class,
    CategoryImage::class],
    version = 1)
@TypeConverters(RoomTypeConverters::class)
public abstract class PrivyPicDatabase : RoomDatabase() {
    abstract fun imageDao(): ImageDao
    abstract fun categoryDao(): CategoryDao
    abstract fun categoryImageDao(): CategoryImageDao
    companion object {
        private var INSTANCE: PrivyPicDatabase? = null

        fun getDatabase(context: Context): PrivyPicDatabase {
            return INSTANCE ?: synchronized(this) {
               val instance = Room.databaseBuilder(
                   context.applicationContext,
                   PrivyPicDatabase::class.java,
                   "privy_pics_database"
               ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}