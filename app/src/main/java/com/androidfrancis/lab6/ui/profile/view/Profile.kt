package com.androidfrancis.lab6.ui.profile.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.androidfrancis.lab6.R
import com.androidfrancis.lab6.ui.TopBar.TopBar


@Composable
fun profileView(navController: NavHostController) {

    Column(

        Modifier
        .fillMaxHeight()){
        TopBar(navController);
        Box(modifier= Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .height(200.dp)
        ){
            Column(modifier = Modifier.padding(top = 50.dp,start=140.dp),
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Icon(modifier= Modifier
                    .size(100.dp)
                    .padding(20.dp)
                    ,painter = painterResource(id = R.drawable.ic_cal2),
                    contentDescription = "",
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Cecilia Castillo")
            }
        }
        Column(){
            Rows(lineas(R.drawable.ic_usuario2,R.drawable.ic_icono1,"Edit Profile"))
            Rows(lineas(R.drawable.ic_candado,R.drawable.ic_icono1,"Reset Password"))
            Row1(lineas(R.drawable.ic_usuario2,R.drawable.ic_icono1,"Notifications"))
            Rows(lineas(R.drawable.ic_estrella,R.drawable.ic_icono1,"Favorites"))
        }
    }
}

@Composable
fun Rows(r: lineas){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()){
        Icon(painter = painterResource(id = r.img),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp),)
        Spacer(modifier = Modifier.width(50.dp))
        Text(r.txt1, modifier= Modifier
            .weight(5.0f))
        Spacer(modifier = Modifier.width(50.dp))
        Icon(modifier= Modifier
            .weight(2.0f)
            .requiredHeight(20.dp), painter = painterResource(id = R.drawable.ic_icono1), contentDescription = "")

    }
}

data class lineas(var img: Int, var img2: Int,  var txt1 : String)

@Composable
fun Row1(r:lineas){
    val isPushEnable = remember{ mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()){
        Icon(painter = painterResource(id = r.img),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp),)
        Spacer(modifier = Modifier.width(50.dp))
        Text(r.txt1, modifier= Modifier
            .weight(5.0f))
        Spacer(modifier = Modifier.width(50.dp))
        Switch(checked = isPushEnable.value,
            //actualizar mutableState value
            onCheckedChange = {isPushEnable.value= it
            }
        )
    }
}