package com.example.navigationapp.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigationapp.components.MainButton
import com.example.navigationapp.components.MainIconButton
import com.example.navigationapp.components.SpaceView
import com.example.navigationapp.components.TitleBar
import com.example.navigationapp.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(navController: NavController,id:Int,optionalParam:String?){
    Scaffold (
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Detail View") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Blue
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ){
        ContentDetailView(navController,id,optionalParam)
    }
}

@Composable
fun ContentDetailView(navController: NavController,id: Int,optionalParam:String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Detail View")
        SpaceView()
        TitleView(name = id.toString())
        SpaceView()
        optionalParam?.let{ TitleView(name = it)}
        if (optionalParam == ""){
            Spacer(modifier = Modifier.height(0.dp))
        }else{
            TitleView(name = optionalParam.orEmpty())
        }
        MainButton(
            name = "Return Home",
            backColor = Color.Blue,
            color = Color.White
        ) {
            navController.popBackStack();
        }
    }
}