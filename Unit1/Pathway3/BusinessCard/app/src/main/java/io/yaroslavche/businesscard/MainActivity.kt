package io.yaroslavche.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.yaroslavche.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x804CAF50))
    ) {
        Column {
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.full_name),
                    fontSize = 48.sp,
                    modifier = modifier
                )
                Text(
                    text = stringResource(R.string.title),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier
                )
            }
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(bottom = 48.dp)
            ) {
                BusinessCardContactInformationRow(
                    imageVector = Icons.Rounded.Phone,
                    text = stringResource(R.string.phoneNumber)
                )
                BusinessCardContactInformationRow(
                    imageVector = Icons.Rounded.Share,
                    text = stringResource(R.string.socialMediaHandle)
                )
                BusinessCardContactInformationRow(
                    imageVector = Icons.Rounded.Email,
                    text = stringResource(R.string.email)
                )
            }
        }
    }
}

@Composable
private fun BusinessCardContactInformationRow(imageVector: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        Spacer(Modifier.width(100.dp))
        Icon(
            imageVector,
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Spacer(Modifier.width(8.dp))
        Text(
            fontSize = 16.sp,
            text = text,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Spacer(Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}