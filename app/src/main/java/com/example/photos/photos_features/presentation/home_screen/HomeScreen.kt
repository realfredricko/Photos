package com.example.photos.photos_features.presentation.home_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.photos.photos_features.presentation.core.PhotosBottomBar
import com.example.photos.photos_features.presentation.core.PhotosList
import com.example.photos.photos_features.utils.Screens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    //Collects PagingData and converts it to LazyPagingItems
    val photo = homeViewModel.getAllPhotos.collectAsLazyPagingItems()
    Scaffold(
        bottomBar = {
            PhotosBottomBar(
                onHomeClicked = { navController.navigate(Screens.Home.route) },
                onSearchClicked = { navController.navigate(Screens.Search.route) }
            )
        },
        content = {
            PhotosList(photos = photo)
        }
    )
}