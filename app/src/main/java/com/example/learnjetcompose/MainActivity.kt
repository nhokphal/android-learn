package com.example.learnjetcompose

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnjetcompose.ui.theme.LearnJetComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnJetComposeTheme {
                // A surface container using the 'background' color from the theme
//                Column() {
//                    OnClickable()
//                    SampaddingComponent()
//                }

                LazyColumn(){
                    item { SampaddingComponent() }
                    item {CustomPadding()}
                    item { offsetCompose ()}
                }

            }
        }
    }
}



///lession 1

@Composable
fun OnClickable() {
    var showPopUp by remember { mutableStateOf(false) }

    Column(Modifier.clickable ( onClick = { showPopUp = true}), content = {
        Card(
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.padding(8.dp),
            ) {
            Text(text = "click me", modifier = Modifier.padding(10.dp)
            ,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif
            ))
        }
    })

    val onShowPopDismiss = { showPopUp = false }
    if(showPopUp){
        AlertDialog(
            onDismissRequest = onShowPopDismiss,
            text = {
                Text( "Congratulations! You just clicked the text successfully")
            },
            confirmButton = {
                Button(onClick = onShowPopDismiss) {
                    Text(text = "Ok")
                }
            }
        )
        }
    }



//lession 2
@Composable
fun SampaddingComponent() {
    Surface() {
        Text(
            text = "this text has equal padding of 16dp",
            modifier = Modifier.padding(16.dp),
            style =  TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
        )
    }
}

@Composable
fun CustomPadding(){
    Surface() {
        Text(
            text = "this is set custome padding",
            modifier = Modifier.padding(start = 32.dp, end= 4.dp, top = 32.dp, bottom = 0.dp),
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
        )
    }
}


@Composable
fun offsetCompose(){
    Surface(modifier = Modifier.offset(x =  9.dp, y = 9.dp)) {
        Text(
            text = "This text is using an offset of 8 dp instead of padding. Padding also ends up" +
            " modifying the size of the layout. Using offset instead ensures that the " +
                    "size of the layout retains its size.",
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)

        )
    }

}



@Composable
fun AspectRatioComponent() {
    Surface(modifier = Modifier
        .aspectRatio(16 / 8f)
        .padding(top = 16.dp)
    ) {
        Text (
            text = "This text is wrapped in a layout that has a fixed aspect ratio of 16/9",
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif),
            modifier = Modifier.padding(20.dp)
        )

    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnJetComposeTheme {
//        OnClickable()
        LazyColumn(){
            item { SampaddingComponent() }
            item { CustomPadding() }
            item { offsetCompose() }
            item { AspectRatioComponent() }
        }
    }
}