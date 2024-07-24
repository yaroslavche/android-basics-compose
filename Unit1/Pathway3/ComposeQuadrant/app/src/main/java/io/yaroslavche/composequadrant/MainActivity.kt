package io.yaroslavche.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.yaroslavche.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ComposeQuadrants()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrant(label: String, description: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(color = color)
            .padding(16.dp)
        ) {
            Text(
                text = label,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
            Text(
                text = description,
                textAlign = TextAlign.Justify,
            )
    }
}

@Composable
fun ComposeQuadrants(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .weight(0.5F)
        ) {
            ComposeQuadrant(
                label = stringResource(R.string.text_composable_label),
                description = stringResource(R.string.text_composable_description),
                color = Color(0xFFEADDFF),
                modifier = modifier
                    .weight(0.5F)
            )
            ComposeQuadrant(
                label = stringResource(R.string.image_composable_label),
                description = stringResource(R.string.image_composable_description),
                color = Color(0xFFD0BCFF),
                modifier = modifier
                    .weight(0.5F)
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .weight(0.5F)
        ) {
            ComposeQuadrant(
                label = stringResource(R.string.row_composable_label),
                description = stringResource(R.string.row_composable_description),
                color = Color(0xFFB69DF8),
                modifier = modifier
                    .weight(0.5F)
            )
            ComposeQuadrant(
                label = stringResource(R.string.column_composable_label),
                description = stringResource(R.string.column_composable_description),
                color = Color(0xFFF6EDFF),
                modifier = modifier
                    .weight(0.5F)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrants()
    }
}