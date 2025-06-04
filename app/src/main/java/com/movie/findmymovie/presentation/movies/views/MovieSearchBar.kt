package com.movie.findmymovie.presentation.movies.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp


@Composable
fun MovieSearchBar(
    modifier: Modifier,
    hint:String ="",
    onSearch:(String)->Unit={}
) {

    var text by remember {
        mutableStateOf("")
    }//burada ve aşağıda 'by' yerine, '=' dersek .value olarak eşitlemeliyiz.
    //bu durumda yukarkdaki runtime.* yerine remember
    //geldiğinde bug oluşup sorun da yapmaz idi.

    var isHintDisplayed by remember {
        mutableStateOf(hint!="")
    }// eğer hint boş değilse isHintDisplayed true olacak

    Box( modifier= modifier){

        TextField(
            value = text,
            keyboardActions = KeyboardActions(onDone = {
                onSearch(text)
            }),
            onValueChange = {
                text = it
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedTextColor = Color.Cyan
            ),

            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp)
                .onFocusChanged {
                    isHintDisplayed = it.isFocused != true && text.isEmpty()
                    //text yazılmamış ve focuslanmamışsa
                }
        )
            if (isHintDisplayed) {

                Text(
                    text = hint,
                    color = Color.LightGray,
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 12.dp)
                )
            }


    }




}