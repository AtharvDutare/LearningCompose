package com.example.learningcomposenavigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.learningcomposenavigation.components.SampleDialog
import com.example.learningcomposenavigation.data.Student
import com.example.learningcomposenavigation.ui.theme.LearningComposeNavigationTheme
import com.example.learningcomposenavigation.viewmodel.SharedViewModel

@Composable
fun ScreenOne(navController: NavController
              ,paddingValues: PaddingValues
              ,sharedViewModel: SharedViewModel
              ,modifier: Modifier=Modifier
              ) {

    val isVisible= remember {
        mutableStateOf(false)
    }
    val dialogData= remember {
        mutableStateOf("")
    }
    when{
        isVisible.value->{
            SampleDialog(
                onDismissRequest = { isVisible.value=false },
                onConfirmation = { isVisible.value=false },
                dialogTitle = "dialogTitle" ,
                dialogText = "dialogText",
                icon = Icons.Sharp.Info,
                onData ={data->dialogData.value=data}// fetch data from dialog to composable
            )
        }
    }

    val sampleStudent= Student(name = "John Blake",
        age = 25,
        address = "New York, USA",
        contact = "1234567890",
        rollNo = 101,
        standard = 12,
        email = "email.@email.com")

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
            Button(onClick = {
                //isVisible.value=true
                navController.navigate("sample dialog")
            }) {
                Text(text = "show dialog")
            }
            Text(text = "hello")
            //sharedViewModel.student.value=sampleStudent
            sharedViewModel.rollNumber.value=101
            Button(onClick = { navController.navigate("screen-two") }) {
                Text(text = "screen to 2")
            }
        }
    }

}
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    LearningComposeNavigationTheme {
//        ScreenOne(modifier = Modifier)
//    }
//}
