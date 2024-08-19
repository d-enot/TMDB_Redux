package com.ksyen.movies_redux.onairshows

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.ksyen.movies_redux.redux.ShowsActions

@Composable
fun OnAirShowsView(modifier: Modifier, viewModel: OnAirShowsViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn {
            items(state.items) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(4.dp)
                ) {
                    Box(modifier = modifier.padding(0.dp)) {
                        Row {
                            Box(modifier = modifier) {
                                Image(
                                    painter = rememberAsyncImagePainter(model = "https://image.tmdb.org/t/p/w500${item.poster}"),
                                    contentDescription = "Poster",
                                    modifier = modifier.size(112.dp)
                                )
                            }
                            Column {
                                Text(
                                    text = item.name,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = item.overview,
                                    maxLines = 3,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.sendAction(ShowsActions.LoadItems)
    }
}