package com.example.learningcomposenavigation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learningcomposenavigation.data.Repository
import com.example.learningcomposenavigation.data.Student

class SharedViewModel(repository: Repository): ViewModel() {
    //val student=MutableLiveData<Student>()
    val rollNumber=MutableLiveData<Int>()
    private val repository by lazy{
        repository
    }
     fun getStudent() :Student{
        return repository.getStudent(rollNo = rollNumber.value?:0)
    }

     fun setStudent(student: Student) {
        repository.setStudent(student)
    }
}