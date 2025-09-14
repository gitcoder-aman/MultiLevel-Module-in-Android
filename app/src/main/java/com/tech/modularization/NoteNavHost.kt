package com.tech.modularization

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tech.modularization.auth.authNavGraph
import com.tech.modularization.auth.authRoute

@Composable
fun NoteNavHost(navHostController: NavHostController) {
    NavHost(
        navController =  navHostController,
        startDestination = authRoute
    ){
        authNavGraph(
            navController = navHostController,
            onAuthSuccess = {

            }
        )
        composable(homeRoute) {

        }
    }
}