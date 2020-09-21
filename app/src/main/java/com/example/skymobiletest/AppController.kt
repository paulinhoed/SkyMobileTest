package com.example.skymobiletest

import android.app.Application
import com.squareup.leakcanary.LeakCanary

class AppController: Application() {
    override fun onCreate() {
        super.onCreate()
        // TODO - Create a debugTest build variant
        if(BuildConfig.memoryTest) {
            if (LeakCanary.isInAnalyzerProcess(this)) {
                // This process is dedicated to LeakCanary for heap analysis.
                // You should not init your app in this process.
                return
            }
            LeakCanary.install(this)
        }
    }
}