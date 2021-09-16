package com.wsr.lazycolumnstudy

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun List(){
    
    val list = remember { listOf("A", "B", "C")}

    LazyColumn(Modifier.fillMaxSize()){
        item{
            for(i in list){
                LazyCard(text = i)
            }
        }
        item { 
            AddButton(onClick = { /*TODO*/ })
        }
    }
}