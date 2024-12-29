package com.romanwit.tipcalculatorjetpackcompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.romanwit.tipcalculatorjetpackcompose.model.BillRow

@Composable
fun BillRowItem(
    row: BillRow,
    onUpdate: (BillRow) -> Unit,
    onRemove: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = row.billAmount.toString(),
            onValueChange = {
                val newValue = it.toDoubleOrNull() ?: 0.0
                onUpdate(row.copy(billAmount = newValue))
            },
            label = { Text("Bill Amount") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        OutlinedTextField(
            value = row.tipPercentage.toString(),
            onValueChange = {
                val newValue = it.toIntOrNull() ?: 0
                onUpdate(row.copy(tipPercentage = newValue))
            },
            label = { Text("Tip %") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "%.2f".format(row.totalAmount),
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = { onRemove() }) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Remove Row"
            )
        }
    }
}
