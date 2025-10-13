package com.example.myapplication.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowUpward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.myapplication.domain.model.NewsItem
import com.example.myapplication.R

@Composable
fun NewsItem(
    modifier: Modifier = Modifier,
    newsItem: NewsItem,
    onFavoriteClicked: () -> Unit,
    onReadClicked: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AsyncImage(
                model = newsItem.imageUrl,
                contentDescription = "Фото новости",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = newsItem.title,
                fontSize = 22.sp,
            )
            Text(
                text = newsItem.description,
                maxLines = 3,
                fontSize = 18.sp,
            )
            StyledButton(
                onClick = {}
            ) {
                Text(text = stringResource(R.string.read))
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    imageVector = Icons.Outlined.ArrowUpward,
                    contentDescription = "Стрелка",
                    modifier = Modifier
                        .rotate(90f)
                )
            }
        }
    }
}