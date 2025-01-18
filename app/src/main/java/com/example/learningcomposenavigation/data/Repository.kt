package com.example.learningcomposenavigation.data

interface Repository {
    fun getStudent(rollNo:Int) :Student
    fun setStudent(student: Student)
}