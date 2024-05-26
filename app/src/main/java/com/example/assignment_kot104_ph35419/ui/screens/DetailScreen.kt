import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.assignment_kot104_ph35419.R

@Composable
fun ProductDetailScreen(navController: NavController, productId: String) {
    val scrollState = rememberScrollState()
    val quantity = remember { mutableStateOf(1) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Box(
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_stand),
                    contentDescription = "Product Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp) // Adjust the height as needed
                        .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp, topStart = 16.dp))
                )
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.TopStart)
                        .background(Color.White.copy(alpha = 0.7f), shape = CircleShape)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }

                Column(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 80.dp, start = 16.dp)
                        .clip(RoundedCornerShape(40.dp))
                        .background(Color.White)



                ) {
                    CircularButton(color = Color.White, onClick = { /* First button action */ })
                    CircularButton(color = Color.LightGray, onClick = { /* Second button action */ })
                    CircularButton(color = Color.Gray, onClick = { /* Third button action */ })
                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "Minimal Stand",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "$ 50",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = {
                            if (quantity.value > 1) quantity.value--
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_minus),
                                contentDescription = "Decrease",
                                tint = Color.Black
                            )
                        }
                        Text(
                            text = "${quantity.value}",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        IconButton(onClick = { quantity.value++ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_plus),
                                contentDescription = "Increase",
                                tint = Color.Black
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = "Rating",
                        tint = Color.Yellow
                    )

                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "4.5",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "(50 reviews)",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Minimal Stand is made of natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        Spacer(modifier = Modifier.height(36.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier.weight(1f).height(60.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_favourite),
                        contentDescription = "Bookmark",
                        tint = Color.Black
                    )
                }

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.weight(2f).height(60.dp)

                ) {
                    Text(text = "Add to cart", color = Color.White)
                }
            }
        }
    }
}


@Composable
fun CircularButton(color: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(10.dp)
            .size(30.dp),
        border = BorderStroke(2.dp, Color.Gray),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {}
}
