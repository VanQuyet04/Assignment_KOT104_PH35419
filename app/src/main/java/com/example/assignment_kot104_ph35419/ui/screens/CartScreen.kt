import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.MaterialTheme
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.assignment_kot104_ph35419.R

data class CartItem(
    val image: Int,
    val name: String,
    val price: Double,
    var quantity: Int
)

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CartScreen(navController)
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CartScreen(navController: NavHostController) {
    val items = remember {
        mutableStateListOf(
            CartItem(R.drawable.minimal_stand, "Minimal Stand", 25.0, 1),
            CartItem(R.drawable.coffee_table, "Coffee Table", 20.0, 1),
            CartItem(R.drawable.minimal_desk, "Minimal Desk", 50.0, 1)
        )
    }
    val total = items.sumOf { it.price * it.quantity }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),

        content = {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    CustomTopBar(
                        title = "My cart",
                        subtitle = null,
                        leftIconId = R.drawable.back,
                        rightIconId = null,
                        onLeftClick = { navController.popBackStack() },
                        onRightClick = { }
                    ) {}

                    LazyColumn {
                        items(items.size) { index ->
                            val item = items[index]
                            CartItemCard(item, onRemove = { items.remove(item) })
                            Spacer(modifier = Modifier.height(10.dp))
                        }
                    }

                    // Khoảng trống giữa danh sách và cột giá + nút
                    Spacer(modifier = Modifier.height(60.dp))

                    // Cột giá và nút checkout
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Total: $${"%.2f".format(total)}",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Button(
                            onClick = { },
                            modifier = Modifier.fillMaxWidth(),
                            shape = MaterialTheme.shapes.medium,
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black, contentColor = Color.White) // Điều chỉnh màu chữ ở đây
                        ) {
                            Text("Check out")
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun CartItemCard(item: CartItem, onRemove: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp, // Adds elevation to the card
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(item.name, fontWeight = FontWeight.Bold)
                    Text("$${item.price}", color = Color.Gray)
                    Spacer(modifier = Modifier.width(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 5.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            var quantity by remember { mutableStateOf(item.quantity) }
                            IconButton(onClick = { if (quantity > 1) quantity-- }) {
                                Icon(Icons.Default.Remove, contentDescription = "Decrease quantity")
                            }
                            Text("$quantity", fontSize = 18.sp)
                            IconButton(onClick = { quantity++ }) {
                                Icon(Icons.Default.Add, contentDescription  = "Increase quantity")
                            }
                        }
                    }
                }
                IconButton(onClick = onRemove) {
                    Icon(Icons.Default.Delete, contentDescription = "Remove item")
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}



