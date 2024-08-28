package com.example.photos.photos_features.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.photos.ui.theme.PhotosTheme

@AndroidEntryPoint
//Will contain all the screens and components in which
//dependencies will be injected
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    Photos()
                }
            }
        }
    }
}

@Composable
fun Photos() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Screens.Home.route) {
        composable(route = Screens.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screens.Search.route) {
            SearchScreen(navController = navController)
        }
    }
}
