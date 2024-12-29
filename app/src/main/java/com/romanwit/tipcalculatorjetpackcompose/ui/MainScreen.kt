package com.romanwit.tipcalculatorjetpackcompose.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.romanwit.tipcalculatorjetpackcompose.viewmodel.BillViewModel
import com.romanwit.tipcalculatorjetpackcompose.ui.components.BillRowItem

@Composable
fun MainScreen(viewModel: BillViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val rows by viewModel.rows.collectAsState()
    val totalSum by viewModel.totalSum.collectAsState(initial = 0.0)

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                itemsIndexed(rows) { index, row ->
                    BillRowItem(
                        row = row,
                        onUpdate = { updatedRow -> viewModel.updateRow(index, updatedRow) },
                        onRemove = { viewModel.removeRow(index) }
                    )
                }
            }
            Text(
                text = "Total: %.2f".format(totalSum),
                style = MaterialTheme.typography.h6,
                modifier = Modifier.align(Alignment.End)
            )
            Button(
                onClick = { viewModel.addRow() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Add Row")
            }
        }
    }
}
