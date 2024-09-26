package com.example.photos.photos_features.presentation.search_screen

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.photos.photos_features.presentation.core.PhotosList
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val querySearch by searchViewModel.querySearch
    //Collects PagingData and converts it to LazyPagingItems
    val searchedPhotos = searchViewModel.searchedPhotos.collectAsLazyPagingItems()

    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                SearchTopBar(
                    text = querySearch,
                    onTextChange = { searchViewModel.queryUpdate(query = it) },
                    onSearchClicked = { searchViewModel.searchUpdate(query = querySearch) },
                    onClosedClicked = { navController.navigateUp() }
                )
            },
            content = {
                PhotosList(photos = searchedPhotos)
            }
        )
    }
}