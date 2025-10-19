package com.example.myapplication.presentation.screen.main.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun FeedScreen() {
    var searchText by remember { mutableStateOf("") }


}

@Composable
fun FeedScreenContent(
    state: FeedScreenState,
    onEvent: (FeedScreenEvent) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = state.searchQuery,
            onValueChange = { onEvent(FeedScreenEvent.SearchQueryChanged(it)) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Иконка поиска",
                    tint = Color.Gray
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.news_search),
                    fontSize = 18.sp,
                )
            },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier.fillMaxWidth(0.9f)
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(0.9f),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(state.filteredNews) {
                com.example.myapplication.presentation.ui.component.NewsItem(
                    newsItem = it,
                    onFavoriteClicked = {},
                    onReadClicked = {
                        onEvent(FeedScreenEvent.NewsItemClicked(it))
                    },
                )
            }
        }
    }
}