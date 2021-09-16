package com.wsr.lazycolumnstudy

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun List(){
    
    val list by remember { mutableStateOf((0..10).toMutableList()) }
    var item by remember { mutableStateOf("TEST") }

    LazyColumn(Modifier.fillMaxSize()){
        item{
            for(i in list){
                LazyCard(text = i.toString())
            }
            LazyCard(text = item)
        }
        item { 
            AddButton(onClick = {
                list.add(list.size)
                item = "OK"
            })
        }
    }
}