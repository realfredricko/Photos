package com.example.photos.photos_features.presentation.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter
import com.example.photos.photos_features.data.model.Photo

@Composable
fun PhotosItem(
    photo: Photo,
    modifier: Modifier = Modifier
){
    Image(painter =rememberAsyncImagePainter(model = photo.urls.regular) ,
        contentDescription = "Photo by ${photo.user.name}",
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium),
        contentScale = ContentScale.Crop
    )
    /*AsyncImage(
        modifier = modifier,
        model = photo.urls.regular,
        contentDescription ="Photo",
        contentScale = ContentScale.Crop)*/

}