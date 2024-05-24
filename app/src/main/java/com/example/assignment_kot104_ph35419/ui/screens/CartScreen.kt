import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

class MainActivity : ComponentActivity() {
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
                        onRightClick = {  }){}

                    items.forEach { item ->
                        CartItemRow(item, onRemove = { items.remove(item) })
                    }
                }
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Total: $${"%.2f".format(total)}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = { /* Chuyển đến màn hình xác nhận */ },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Check out")
                    }
                }
            }
        }
    )
}


@Composable
fun CartItemRow(item: CartItem, onRemove: () -> Unit) {
    var quantity by remember {
        mutableStateOf(item.quantity)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(item.name, fontWeight = FontWeight.Bold)
            Text("$${item.price}", color = Color.Gray)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { if (quantity > 1) quantity-- }) {
                Icon(Icons.Default.Remove, contentDescription = "Decrease quantity")
            }
            Text("${item.quantity}", fontSize = 18.sp)
            IconButton(onClick = { quantity++ }) {
                Icon(Icons.Default.Add, contentDescription = "Increase quantity")
            }
        }
        IconButton(onClick = onRemove) {
            Icon(Icons.Default.Delete, contentDescription = "Remove item")
        }
    }
}
