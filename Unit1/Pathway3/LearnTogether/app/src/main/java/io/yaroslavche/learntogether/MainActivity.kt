package io.yaroslavche.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.yaroslavche.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Article(
                        icon = painterResource(R.drawable.bg_compose_background),
                        name = stringResource(R.string.name),
                        description = stringResource(R.string.description),
                        content = stringResource(R.string.content)
                    )
                }
            }
        }
    }
}

@Composable
fun Article(icon: Painter, name: String, description: String, content: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column {
            Image(
                painter = icon,
                contentDescription = null
            )
            Text(
                text = name,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(16.dp)
            )
            Text(
                text = description,
                textAlign = TextAlign.Justify,
                modifier = modifier
                    .padding(horizontal = 16.dp)
            )
            Text(
                text = content,
                textAlign = TextAlign.Justify,
                modifier = modifier
                    .padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    LearnTogetherTheme {
        Article(
            icon = painterResource(R.drawable.bg_compose_background),
            name = stringResource(R.string.name),
            description = stringResource(R.string.description),
            content = stringResource(R.string.content)
        )
    }
}