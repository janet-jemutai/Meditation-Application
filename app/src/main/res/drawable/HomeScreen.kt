package drawable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jemutai.meditationapplication.Feature
import com.jemutai.meditationapplication.R
import com.jemutai.meditationapplication.ui.theme.ButtonBlue
import com.jemutai.meditationapplication.ui.theme.DarkerButtonBlue
import com.jemutai.meditationapplication.ui.theme.DeepBlue
import com.jemutai.meditationapplication.ui.theme.LightRed
import com.jemutai.meditationapplication.ui.theme.TextWhite
import com.jemutai.meditationapplication.R.drawable as drawable1

@Composable
fun  HomeScreen(){
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()
    ){
        Column {

            GreetingSection()
            
            ChipSection(chips = listOf("Sweet Sleep","Insomia","Depression") )

            CurrenttMeditation()

        }
    }

}

@Composable
fun GreetingSection(name: String = "Jemutai"){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ){
        Column(
            verticalArrangement = Arrangement.Center
        ) {

            Text(text = "Good Morning,$name",
                style =MaterialTheme.typography.headlineMedium )

            Text(text = "We wish  you have  a good day!",
                style =MaterialTheme.typography.bodySmall )


        }

           Icon(painter = painterResource(id = drawable1.ic_search), contentDescription ="Search" ,
             tint = Color.White,
               modifier = Modifier.size(24.dp
               ))


    }
}

@Composable

fun  ChipSection(
    chips:List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            )
            {
                Text(text = chips[it], color = TextWhite)
            }
        }


    }
}

@Composable
fun  CurrenttMeditation(color: Color = LightRed){

Row (
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier
        .padding(15.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(color)
        .padding(horizontal = 15.dp, vertical = 20.dp)
        .fillMaxHeight()
){
    Column {
        Text(text = "Daily Thought",
            style =MaterialTheme.typography.headlineMedium )

        Text(text = "Meditation . 2.20 min",
            style =MaterialTheme.typography.bodySmall,
            color = TextWhite)
    }
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(ButtonBlue)
            .padding(10.dp)){
        
        Icon(painter = painterResource(id = R.drawable.ic_play), contentDescription ="Play",
            tint = Color.White,
            modifier = Modifier.size(16.dp)
        )


    }
    }
}

@Composable
fun FeatureSection( features: List<Feature>){
  Column (modifier = Modifier.fillMaxWidth()){

      Text(text = "Features",
          style = MaterialTheme.typography.headlineSmall,
          modifier =  Modifier.padding(15.dp))

      LazyVerticalGrid(
          columns = GridCells.Fixed(2),
          contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
          modifier = Modifier.fillMaxHeight()
      ) {
items(features.size){

}
      }

  }

}