package com.wsr.lazycolumnstudy

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun List(){
    
    var list by remember { mutableStateOf((0..3).toList()) }

    LazyColumn(Modifier.fillMaxSize()){
        item{
            for(i in list){
                LazyCard(text = i.toString())
            }
        }
        item { 
            AddButton(onClick = {
                list = list + listOf(list.size)
            })
        }
    }
}