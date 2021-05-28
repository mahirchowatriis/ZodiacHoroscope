package edu.uwindsor.zodiachoroscope.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface ZodiacDao {

    @Query("SELECT * FROM ZodiacItem")
    fun getSigns(): LiveData<List<ZodiacItem>>

}