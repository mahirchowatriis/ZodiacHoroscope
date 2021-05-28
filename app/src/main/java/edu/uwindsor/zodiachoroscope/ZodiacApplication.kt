package edu.uwindsor.zodiachoroscope

import android.app.Application

class ZodiacApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        ZodiacRepo.initialize(this)
    }
}