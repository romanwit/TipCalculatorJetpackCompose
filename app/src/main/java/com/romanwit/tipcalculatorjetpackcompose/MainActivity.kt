package com.romanwit.tipcalculatorjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.romanwit.tipcalculatorjetpackcompose.model.BillRow
import com.romanwit.tipcalculatorjetpackcompose.ui.theme.MainScreen
import com.romanwit.tipcalculatorjetpackcompose.viewmodel.BillViewModel
//import com.romanwit.tipcalculatorjetpackcompose.ui.theme.TipCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //TipCalculatorTheme {
                MainScreen()
            //}
        }
    }
}
