package com.example.birthdayreminder

import android.content.res.Configuration
import android.icu.text.BidiRun
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
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
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Column {
                        Title(profileInfo = ProfileInfo("Niall"))
                        UpcomingBirthdays(birthdays = SampleData.birthdaysSample)
                    }

                }
            }
        }
    }
}

data class ProfileInfo(val user: String)
data class UpcomingBirthday(val name: String, val date: String)

@Composable
fun Title(profileInfo: ProfileInfo){
    Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().padding(8.dp)){
        Image(
            painter = painterResource(id = R.drawable.birthday_cake),
            contentDescription = "Birthday cake image",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape),
            contentScale = ContentScale.FillHeight
        )

        Row (){
            Text(text = "Welcome ")
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp){
                Text(text = profileInfo.user, color = MaterialTheme.colors.secondaryVariant)
            }
        }
    }
}

@Composable
fun Birthday(upB: UpcomingBirthday) {
    Row (verticalAlignment = Alignment.CenterVertically){
        Image(
            painter = painterResource(id = R.drawable.birthday_cake),
            contentDescription = "Birthday cake image",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
                .padding(8.dp),
            contentScale = ContentScale.FillHeight
        )
        Column (modifier = Modifier.padding(8.dp)){
            Text(text = upB.name)
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp){
                Text(text = upB.date, color = MaterialTheme.colors.secondaryVariant)
            }
        }
    }
}

@Composable
fun UpcomingBirthdays(birthdays: List<UpcomingBirthday>) {
    LazyColumn{
        items(birthdays.size) { upcomingBirthday ->
            Birthday(birthdays[upcomingBirthday])
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
//@Preview(
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    showBackground = true,
//    name = "Dark Mode"
//)
@Composable
fun PreviewTitle() {
    BirthdayReminderTheme {
        Surface{
            Title(profileInfo = ProfileInfo("Niall" + "!"))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewBirthdayList() {
    BirthdayReminderTheme() {
        Surface{
            UpcomingBirthdays(birthdays = SampleData.birthdaysSample)
        }

    }
}