package com.tech.modularization.auth

import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tech.modularization.auth.login.LoginScreen
import com.tech.modularization.auth.splash.SplashScreen

const val authRoute = "auth"
sealed class  AuthScreen(val route : String){
    data object  Splash : AuthScreen("$authRoute/splash")
    data object  Login : AuthScreen("$authRoute/login")
    data object  Signup : AuthScreen("$authRoute/signup")
}

fun NavGraphBuilder.authNavGraph(
    onAuthSuccess : () -> Unit,
    navController : NavController
){
    navigation(startDestination = AuthScreen.Splash.route,route = authRoute){
        composable(AuthScreen.Splash.route) {
            SplashScreen(
                splashViewModel = hiltViewModel(),
                navController = navController,
                onAuthSuccess = onAuthSuccess
            )
        }
        composable(AuthScreen.Login.route){
            LoginScreen(
                loginViewmodel = hiltViewModel(),
                onAuthAccess = onAuthSuccess
            )
        }
    }

}