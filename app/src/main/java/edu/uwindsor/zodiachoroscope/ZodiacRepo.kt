package edu.uwindsor.zodiachoroscope

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import edu.uwindsor.zodiachoroscope.data.ZodiacDatabase
import edu.uwindsor.zodiachoroscope.data.ZodiacItem

private const val DATABASE_NAME = "horoscope-database.sqlite"

class ZodiacRepo private constructor(context: Context){

    private val db: ZodiacDatabase = Room.databaseBuilder(
        context.applicationContext,
        ZodiacDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().createFromAsset("database/$DATABASE_NAME").build()

    private val zodiacDao = db.zodiacDao()

    fun getSigns(): LiveData<List<ZodiacItem>> = zodiacDao.getSigns()


    companion object{
        private var INSTANCE: ZodiacRepo? = null

        fun initialize(context: Context){
            if (INSTANCE == null)
                INSTANCE = ZodiacRepo(context)
        }

        fun get(): ZodiacRepo{
            return  INSTANCE?:
            throw IllegalStateException("ZodiacRepository must be initialized.")
        }
    }
}