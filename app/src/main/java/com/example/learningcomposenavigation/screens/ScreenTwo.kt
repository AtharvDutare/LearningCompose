package com.example.learningcomposenavigation.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.learningcomposenavigation.App
import com.example.learningcomposenavigation.MyApplication
import com.example.learningcomposenavigation.viewmodel.SharedViewModel


@Composable
fun ScreenTwo(navController: NavController
              ,paddingValues: PaddingValues
              ,sharedViewModel: SharedViewModel
              ,modifier: Modifier=Modifier
) {
    val context= LocalContext.current
    val AppContext=context.applicationContext as MyApplication
    val repo= AppContext.getRepo()
    Surface(
        modifier=Modifier.fillMaxSize()
        , color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier= Modifier
                .fillMaxSize()
                .padding(paddingValues)
            , verticalArrangement = Arrangement.Center
            , horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "previous screen")
            }
//            val data= navController.currentBackStackEntry?.arguments?.getString("rollNo")?:"0"
//            val intData=data.toInt()
//            val StudentObj=repo.getStudent(intData)


           // val studentData=sharedViewModel.student.value
            val student=sharedViewModel.getStudent()
            Text(text="text $student")

            Button(onClick = { navController.navigate("screen-three") }) {
                Text(text = "next screen")
            }
        }
    }
}
