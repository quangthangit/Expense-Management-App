package com.example.expensemanagementapp.util

import com.example.expensemanagementapp.R
import com.example.expensemanagementapp.data.ExpenseCategory

class IncomeData {
    companion object {
        fun data(): List<ExpenseCategory> {
            return listOf(
                ExpenseCategory(13, "Lương", R.drawable.icon_wallet, "#388E3C"),
                ExpenseCategory(14, "Thưởng", R.drawable.icon_chart, "#7CB342"),
                ExpenseCategory(15, "Kinh doanh", R.drawable.icon_wallet, "#8BC34A"),
                ExpenseCategory(16, "Lãi đầu tư", R.drawable.icon_chart, "#689F38"),
                ExpenseCategory(17, "Tiền hỗ trợ", R.drawable.icon_wallet, "#CDDC39"),
                ExpenseCategory(18, "Khác", R.drawable.icon_chart, "#C8E6C9")
            )
        }
    }
}