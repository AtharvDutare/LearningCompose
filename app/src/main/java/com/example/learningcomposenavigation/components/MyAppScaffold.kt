package com.example.learningcomposenavigation.components

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material.icons.sharp.Face
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.learningcomposenavigation.screens.ScreenOne
import com.example.learningcomposenavigation.screens.ScreenThree
import com.example.learningcomposenavigation.screens.ScreenTwo
import com.example.learningcomposenavigation.viewmodel.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppScaffold(navController: NavController,sharedViewModel: SharedViewModel) {
    var isbackEnabled= remember {
        mutableStateOf(false)
    }
    navController.addOnDestinationChangedListener{
            controller: NavController,
            destination: NavDestination,
            arguments: Bundle?->
        Log.i("navigation check","the destination is ${destination.route}")
        isbackEnabled.value=destination.route=="screen-one"
    }
    var homeIconChange=if(isbackEnabled.value) {
        Icons.Sharp.Home
    }
    else {
        Icons.Sharp.ArrowBack
    }
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                        Text(text="myScaffold", style = MaterialTheme.typography.bodyLarge)
                        }
                , colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
                ,
                navigationIcon = {
                    IconButton(onClick = { if(!isbackEnabled.value) {navController.popBackStack()} }) {
                        Icon(imageVector = homeIconChange, contentDescription = "home button")
                    }
                }
            )
        },

    ) {
        paddingValues ->
        NavHost(navController = navController as NavHostController, graph = getMyNavGraph(navController,paddingValues,sharedViewModel))

    }
}



fun getMyNavGraph(navController: NavHostController
                  ,paddingValues: PaddingValues
                    ,sharedViewModel: SharedViewModel
): NavGraph {
    return navController.createGraph(startDestination = "screen-one") {
        composable("screen-one") {
            ScreenOne(navController,paddingValues,sharedViewModel)
        }
        composable("screen-two") {
//            val stringData= it.arguments?.getString("rollNo")?:"0"
//            val data=stringData.toInt()
//            navController.currentBackStackEntry?.arguments?.apply {
//                putInt("rollNo",data)
//            }
            ScreenTwo(navController,paddingValues,sharedViewModel)
        }
        composable("screen-three") {
            ScreenThree(navController,paddingValues)
        }
        dialog("sample dialog") {
            SampleDialog(
                onDismissRequest = { navController.popBackStack()},
                onConfirmation = { navController.popBackStack()},
                dialogTitle = "this is dialogTitle",
                dialogText = "this is dialogText",
                icon = Icons.Sharp.Face
            ) {

            }
        }
    }

}


//NavGraph
//fun NavGraphBuilder.navigationGraph(navController: NavController
//                                    ,paddingValues: PaddingValues) {
//    composable("screen-one") {
//        ScreenOne(navController,paddingValues)
//    }
//    composable("screen-two/{rollNo}") {
//        val stringData= it.arguments?.getString("rollNo")?:"0"
//        val data=stringData.toInt()
//        navController.currentBackStackEntry?.arguments?.apply {
//            putInt("rollNo",data)
//        }
//        ScreenTwo(navController,paddingValues)
//    }
//    composable("screen-three") {
//        ScreenThree(navController,paddingValues)
//    }
//
//}
