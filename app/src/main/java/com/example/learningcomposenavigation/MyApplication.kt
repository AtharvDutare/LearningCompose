package com.example.learningcomposenavigation

import android.app.Application
import com.example.learningcomposenavigation.data.AppRepository

class MyApplication:Application() {
    private lateinit var repo:AppRepository
    override fun onCreate() {
        super.onCreate()
        repo=AppRepository()
    }
    fun getRepo(): AppRepository {
        return repo
    }
}