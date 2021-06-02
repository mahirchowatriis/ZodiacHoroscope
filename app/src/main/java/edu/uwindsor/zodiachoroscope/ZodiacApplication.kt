package edu.uwindsor.zodiachoroscope

import android.app.Application
import edu.uwindsor.zodiachoroscope.data.ZodiacRepo

class ZodiacApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        ZodiacRepo.initialize(this)
    }
}