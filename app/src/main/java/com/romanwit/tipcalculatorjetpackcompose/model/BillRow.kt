package com.romanwit.tipcalculatorjetpackcompose.model

data class BillRow(
    val billAmount: Double = 0.0,
    val tipPercentage: Int = 0
) {
    val totalAmount: Double
        get() = billAmount * (1 + tipPercentage / 100.0)
}
