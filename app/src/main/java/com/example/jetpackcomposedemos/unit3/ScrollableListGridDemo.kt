package com.example.jetpackcomposedemos.unit3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemos.R
import com.example.jetpackcomposedemos.unit3.data.DataSource
import com.example.jetpackcomposedemos.unit3.model.Affirmation
import com.example.jetpackcomposedemos.unit3.ui.theme.JetpackComposeDemosTheme


class ScrollableListGridDemo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationsListGridApp()
                }
            }
        }
    }
}

@Composable
fun AffirmationsListGridApp() {

    var isList by remember { mutableStateOf(false) }

    Column {
        Button(onClick = {
            isList = !isList
        }) {
            Text(text = "Change", fontSize = 24.sp)
        }

        if (!isList) {
            AffirmationListDemo(affirmationList = DataSource().loadAffirmation())
        } else {
            AffirmationGrid(affirmationList = DataSource().loadAffirmation())
        }
    }

}

@Composable
fun AffirmationListDemo(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(affirmationList) { affirmation ->
            AffirmationListCard(
                affirmation = affirmation,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun AffirmationGrid(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
    ) {
        items(affirmationList) { affirmation ->
            AffirmationGridCard(
                affirmation = affirmation
            )
        }
    }
}

@Composable
fun AffirmationListCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(id = affirmation.imageResourceId),
                contentDescription = stringResource(
                    id = affirmation.stringResourceId
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = LocalContext.current.getString(affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }

}

@Composable
fun AffirmationGridCard(affirmation: Affirmation) {
    Card {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = affirmation.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 68.dp, height = 68.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop

            )
            Text(
                text = LocalContext.current.getString(affirmation.stringResourceId),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small)),
            )

        }
    }
}


//@Preview(showSystemUi = true, device = "id:pixel_3a")
@Preview(showBackground = true)
@Composable
fun GreetingPreview14() {
    JetpackComposeDemosTheme {
        AffirmationsListGridApp()
        // AffirmationListCard(Affirmation(R.string.affirmation1, R.drawable.image1))
        //  AffirmationGridCard(Affirmation(R.string.affirmation1, R.drawable.image1))
    }
}