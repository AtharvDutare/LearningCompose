package com.example.learningcomposenavigation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.learningcomposenavigation.components.MyAppScaffold
import com.example.learningcomposenavigation.data.AppRepository
import com.example.learningcomposenavigation.data.Repository
import com.example.learningcomposenavigation.viewmodel.SharedViewModel


@Composable
fun App() {
    val navController= rememberNavController()
    val context= LocalContext.current
    val AppContext=context.applicationContext as MyApplication
    val sharedViewModel= remember {
        SharedViewModel(repository = AppContext.getRepo())
    }
    MyAppScaffold(navController = navController,sharedViewModel)
}


//@Composable
//fun App() {
//    //NavController
//    val navController= rememberNavController()
//    MyAppScaffold(navController = navController)
//navController.addOnDestinationChangedListener(MyOnDestinationChanged())
//    navController.addOnDestinationChangedListener{
//            controller: NavController,
//            destination: NavDestination,
//            arguments: Bundle?->
//        Log.i("navigation check","the destination is ${destination.route}")
//    }
//    NavHost
//    NavHost(navController = navController, startDestination = "screen-one") {
//        navigationGraph(navController)
//    }
//    NavHost(navController = navController, graph = getMyNavGraph(navController))
//}
//
//class MyOnDestinationChanged:NavController.OnDestinationChangedListener{
//    override fun onDestinationChanged(
//        controller: NavController,
//        destination: NavDestination,
//        arguments: Bundle?
//    ) {
//
//    }
//}
//
//fun getMyNavGraph(navController: NavHostController): NavGraph {
//    return navController.createGraph(startDestination = "screen-one") {
//        composable("screen-one") {
//            ScreenOne(navController)
//        }
//        composable("screen-two") {
//            ScreenTwo(navController)
//        }
//        composable("screen-three") {
//            ScreenThree(navController)
//        }
//    }
//
//}
//
//
////NavGraph
//fun NavGraphBuilder.navigationGraph(navController: NavController) {
//    composable("screen-one") {
//        ScreenOne(navController)
//    }
//    composable("screen-two") {
//        ScreenTwo(navController)
//    }
//    composable("screen-three") {
//        ScreenThree(navController)
//    }
//
//}
