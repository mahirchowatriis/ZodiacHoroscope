package edu.uwindsor.zodiachoroscope.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ZodiacItem::class], version = 1)
abstract class ZodiacDatabase: RoomDatabase()  {
    abstract fun zodiacDao(): ZodiacDao
}