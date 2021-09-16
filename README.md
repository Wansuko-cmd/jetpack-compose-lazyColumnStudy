# jetpack-compose-lazyColumnStudy


# Listを保持する際のrememberの動作について

RecyclerViewのように、付け足したり消したりできるリストを使おうと思い、MutableListを利用すると罠にはまる可能性が高くなる

```
var list: MutableList<Int> by remember { mutableStateOf((0..3).toMutableList()) }
```

上記のように書き、いざリストの付け足しを行おうとすると、一切再コンポースが行われず発狂する

```
//リストを表示する処理
LazyColumn(Modifier.fillMaxSize()){
  item{
    for(i in list){
      Text(text = i.toString())
    }
  }
  
  //押せばリストを増やすボタン
  item{
    Button(
      modifier = Modifier.fillMaxWidth(),
      
      //リストを増やす処理
      onClick = {
        val tempList = list
        tempList.add(list.size)
        list = tempList
      }
    )
  }
}

```

これはリストを増やす処理に問題がある
どうやらこの場合、参照渡しのような動作になっているようで、tempList.add(list.size)とした時点でlistの方にも反映されている
また、MutableListのaddでは、rememberが差分を感知しないため、値を流さない
最後の代入も、同じ値を代入しているだけなので意味がない
そのため動かない

回避するためにはListを使うようにすれば問題ない


```
var list: List<Int> by remember { mutableStateOf((0..3).toList()) }

//リストを表示する処理
LazyColumn(Modifier.fillMaxSize()){
  item{
    for(i in list){
      Text(text = i.toString())
    }
  }
  
  //押せばリストを増やすボタン
  item{
    Button(
      modifier = Modifier.fillMaxWidth(),
      
      //リストを増やす処理
      onClick = { list = list + listOf(list.size) }
    )
  }
}

```

このように新しくlistを作成し、再代入する形にすれば、確実に反応する。
MutableListだとaddを使ってしまうので、listを使うようにするべきである
