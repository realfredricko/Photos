package com.example.photos.photos_features.presentation.core

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import com.example.photos.photos_features.data.model.Photo


@Composable
fun PhotosList(
    photos:LazyPagingItems<Photo>,
    modifier: Modifier =Modifier
){
    LazyColumn (
        modifier = modifier
    ){
        items(count = photos.itemCount,
            key = photos.itemKey {
                it.id
            }){
                index ->
            val photo = photos[index]
            photo.let {
                if (it != null) {
                    PhotosItem(photo = it)
                    HorizontalDivider(thickness = 8.dp)
                }
            }
        }
    }
}
