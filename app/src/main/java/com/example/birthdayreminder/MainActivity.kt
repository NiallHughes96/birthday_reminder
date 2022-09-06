package com.example.birthdayreminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.birthdayreminder.ui.theme.BirthdayReminderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayReminderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Title(profileInfo = ProfileInfo("Niall", "Welcome "))
                }
            }
        }
    }
}

data class ProfileInfo(val user: String, val message: String)

@Composable
fun Title(profileInfo: ProfileInfo) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.birthday_cake),
            contentDescription = "Birthday cake image",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Row (modifier = Modifier.padding(8.dp)){
            Text(text = profileInfo.message)
            Text(text = profileInfo.user)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTitle() {
    BirthdayReminderTheme {
        Title(profileInfo = ProfileInfo("Niall" + "!", "Welcome "))
    }
}