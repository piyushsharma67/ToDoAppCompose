package com.example.todoappcompose.ui.screens.addToDo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.todoappcompose.R

enum class NavigationIconType(){
    Back,
    Menu
}

@Composable
fun MyTopBar(
    title:String,
    navigationIcon:NavigationIconType,
    onClickNavigationIcon:() -> Unit,
    actions: @Composable() (RowScope.() -> Unit),
    modifier: Modifier=Modifier
){
    @Composable
    fun getNavigationIcon(){
        return when(navigationIcon){
            NavigationIconType.Back -> Icon(
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = "back icon",
                modifier = modifier.clickable { onClickNavigationIcon() },
                tint = MaterialTheme.colorScheme.onSecondary
            )
            NavigationIconType.Menu -> Icon(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "menu icon",
                modifier = modifier.clickable { onClickNavigationIcon() },
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
    return SmallTopAppBar(
        title = {
            Text(text = title, modifier = modifier.padding(start = 6.dp), color = MaterialTheme.colorScheme.onSecondary)
        },
        modifier = Modifier,
        navigationIcon = { getNavigationIcon() },
        colors = TopAppBarDefaults.smallTopAppBarColors(MaterialTheme.colorScheme.primary),
        actions = actions
    )
}