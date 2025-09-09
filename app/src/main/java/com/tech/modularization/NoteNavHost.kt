package com.tech.modularization

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.tech.auth.authNavGraph
import com.tech.auth.authRoute

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
    }
}