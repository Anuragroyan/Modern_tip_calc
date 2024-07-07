package com.example.modern_tip_calc

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Modern_tip_calc()
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun Modern_tip_calc(){
    var inputAmt by remember { mutableStateOf("") }
    var outputAmt by remember { mutableStateOf("") }
    var outputAmt1 by remember { mutableStateOf("") }
    var outputAmt2 by remember { mutableStateOf("") }
    var outputAmt3 by remember { mutableStateOf("") }
    var outputAmt4 by remember { mutableStateOf("") }
    var finalamt by remember { mutableStateOf("") }
    fun FinalBill() {
        finalamt = outputAmt.toString()
        val total = inputAmt.toDouble() + outputAmt.toDouble()
        finalamt = total.toString()
    }
    fun calculateTip1() {
        val inputamt = inputAmt.toDouble()
        val tip = inputamt * 0.2
        val total = inputamt + tip
        outputAmt1 = total.toString()
        outputAmt = outputAmt1
        FinalBill()
    }
    fun calculateTip2() {
        val inputamt = inputAmt.toDouble()
        val tip = inputamt * 0.3
        val total = inputamt + tip
        outputAmt2 = total.toString()
        outputAmt = outputAmt2
        FinalBill()
    }
    fun calculateTip3() {
        val inputamt = inputAmt.toDouble()
        val tip = inputamt * 0.5
        val total = inputamt + tip
        outputAmt3 = total.toString()
        outputAmt = outputAmt3
        FinalBill()
    }
    fun calculateTip4() {
        val inputamt = inputAmt.toDouble()
        val tip = inputamt * 0.7
        val total = inputamt + tip
        outputAmt4 = total.toString()
        outputAmt = outputAmt4
        FinalBill()
    }
    Text("   Restaurant Calc",modifier=Modifier.padding(64.dp),
        style = MaterialTheme.typography.headlineLarge,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Monospace
        )
    Column(
        modifier = Modifier
            .padding(45.dp)
            .width(56.dp)
            .height(70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(painter = painterResource(id=R.drawable.tip_cal), contentDescription = "Restaurant Tip Calc",
            modifier = Modifier.size(90.dp),
            alignment = Alignment.Center
        )
    }
    Column(
        modifier = Modifier
            .padding(60.dp)
            .height(390.dp),
    ) {
        Spacer(modifier = Modifier.height(110.dp))
        TextField(value = inputAmt, onValueChange = {inputAmt=it}, label = { Text("Enter Bill Amount")})
    }
    Row(
        modifier = Modifier
            .padding(60.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.height(440.dp))
        Button(onClick = { calculateTip1() }) {
            Text(text = "20%")
        }
        Spacer(modifier = Modifier.width(30.dp))
        Button(onClick = { calculateTip2() }) {
            Text(text = "30%")
        }
        Spacer(modifier = Modifier.width(30.dp))
        Button(onClick = { calculateTip3() }) {
            Text(text = "50%")
        }
    }
    Column(
        modifier = Modifier
            .padding(top = 60.dp, start = 170.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(260.dp))
        Spacer(modifier = Modifier.width(40.dp))
        Button(onClick = { calculateTip4() }) {
            Text(text = "70%")
        }
    }
    Card(
        modifier = Modifier
            .padding(top = 430.dp, start = 50.dp, end = 70.dp, bottom = 70.dp)
            .height(250.dp)
            .width(900.dp)
    ) {
        Row(
           modifier = Modifier
               .padding(top = 30.dp, start = 10.dp, end = 20.dp, bottom = 20.dp)
               .height(29.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.bills), contentDescription = "", modifier = Modifier.size(30.dp),
                alignment = Alignment.Center)

            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Total Bill: ${inputAmt}",fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }
        Row(
            modifier = Modifier
                .padding(top = 30.dp, start = 10.dp, end = 20.dp, bottom = 20.dp)
                .height(29.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.percentage), contentDescription = "", modifier = Modifier.size(30.dp),
                alignment = Alignment.Center)

            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Tip Amt: ${outputAmt} ",fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }
        Row(
            modifier = Modifier
                .padding(top = 30.dp, start = 10.dp, end = 20.dp, bottom = 20.dp)
                .height(29.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.bill), contentDescription = "", modifier = Modifier.size(30.dp),
                alignment = Alignment.Center)

            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Total Amt: ${finalamt}",fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }
    }

}


@Composable
@Preview(showBackground = false)
fun Modern_tip_calcPreview(){
    Modern_tip_calc()
}