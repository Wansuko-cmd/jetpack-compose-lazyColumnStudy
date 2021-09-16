package com.wsr.lazycolumnstudy

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun List(){
    
    var list = remember { mutableStateOf((0..3).toMutableList()) }

    LazyColumn(Modifier.fillMaxSize()){
        item{
            for(i in list.value){
                LazyCard(text = i.toString())
            }
        }
        item { 
            AddButton(onClick = {
//                Log.d("Hello", (list + listOf(list.size)).toString())

                val tempList = list.value
                tempList.add(list.value.size)
                Log.d("Hello", "list: ${list.value}")
                Log.d("Hello", "tempList: $tempList")
                Log.d("Hello", (list.value == tempList).toString())

                list.value = tempList
            })
        }
    }
}