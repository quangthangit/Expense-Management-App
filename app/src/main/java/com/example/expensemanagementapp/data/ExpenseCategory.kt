package com.example.expensemanagementapp.data

import com.example.expensemanagementapp.R

data class ExpenseCategory(
    val id: Int,
    val name: String,
    val iconResId: Int,
    val colorHex: String,
    val isCustom: Boolean = false
)

