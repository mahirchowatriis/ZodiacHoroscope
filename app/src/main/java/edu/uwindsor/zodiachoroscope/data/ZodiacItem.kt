package edu.uwindsor.zodiachoroscope.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ZodiacItem(@PrimaryKey val id : Int = 0,
                      @ColumnInfo(name = "name") val name: String = "",
                      @ColumnInfo(name = "description") val description:String ="",
                      @ColumnInfo(name = "symbol") val symbol: Int=0,
                      @ColumnInfo(name = "month") val month:String=""
                      )