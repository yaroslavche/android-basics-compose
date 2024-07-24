package io.yaroslavche.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.yaroslavche.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CompletedScreen(text = "All tasks completed", helpText = "Nice work!")
                }
            }
        }
    }
}

@Composable
fun CompletedScreen(text: String, helpText: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(top = 24.dp, bottom = 8.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = helpText,
            fontSize = 16.sp,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        CompletedScreen(text = "All tasks completed", helpText = "Nice work!")
    }
}