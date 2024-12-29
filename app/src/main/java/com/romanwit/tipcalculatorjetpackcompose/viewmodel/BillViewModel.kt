package com.romanwit.tipcalculatorjetpackcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.romanwit.tipcalculatorjetpackcompose.model.BillRow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class BillViewModel : ViewModel() {
    private val _rows = MutableStateFlow<List<BillRow>>(emptyList())
    val rows: StateFlow<List<BillRow>> = _rows

    val totalSum: StateFlow<Double> = _rows.map { rows ->
        rows.sumOf { it.totalAmount }
    }
        .stateIn(
            scope = CoroutineScope(Dispatchers.Main),
            started = kotlinx.coroutines.flow.SharingStarted.Eagerly,
            initialValue = 0.0
        )

    fun addRow() {
        _rows.value = _rows.value + BillRow()
    }

    fun updateRow(index: Int, updatedRow: BillRow) {
        _rows.value = _rows.value.toMutableList().apply {
            set(index, updatedRow)
        }
    }

    fun removeRow(index: Int) {
        _rows.value = _rows.value.toMutableList().apply {
            removeAt(index)
        }
    }
}
