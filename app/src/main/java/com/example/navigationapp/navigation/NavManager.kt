package com.example.navigationapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationapp.views.DetailView
import com.example.navigationapp.views.HomeView

@Composable
fun NavManager(){
    val navController = rememberNavController();
    NavHost(
        navController = navController,
        startDestination = "Home"
    ){
        composable("Home"){
            HomeView(navController)
        }
        composable("Detail/{id}/?{optionalParam}", arguments = listOf(
            navArgument("id"){ type = NavType.IntType }
        )){
            val id = it.arguments?.getInt("id") ?: 0
            val optionalParam = it.arguments?.getString("optionalParam") ?: ""
            DetailView(navController,id,optionalParam)
        }
    }
}