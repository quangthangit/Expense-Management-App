package com.example.expensemanagementapp.util

import com.example.expensemanagementapp.R
import com.example.expensemanagementapp.data.ExpenseCategory

class ExpenseData {
    companion object {
        fun data(): List<ExpenseCategory> {
            return listOf(
                ExpenseCategory(1, "Ăn uống", R.drawable.icon_chart, "#FF6F00"),
                ExpenseCategory(2, "Nhà cửa", R.drawable.icon_wallet, "#4CAF50"),
                ExpenseCategory(3, "Di chuyển", R.drawable.icon_chart, "#03A9F4"),
                ExpenseCategory(4, "Giáo dục", R.drawable.icon_wallet, "#9C27B0"),
                ExpenseCategory(5, "Sức khỏe", R.drawable.icon_chart, "#E91E63"),
                ExpenseCategory(6, "Mua sắm", R.drawable.icon_wallet, "#FF9800"),
                ExpenseCategory(7, "Giải trí", R.drawable.icon_chart, "#00BCD4"),
                ExpenseCategory(8, "Gia đình", R.drawable.icon_wallet, "#795548"),
                ExpenseCategory(9, "Tài chính", R.drawable.icon_chart, "#607D8B"),
                ExpenseCategory(10, "Thú Cưng", R.drawable.icon_wallet, "#9E9E9E"),
                ExpenseCategory(11, "Quà Tặng", R.drawable.icon_chart, "#795548"),
                ExpenseCategory(12, "Khác", R.drawable.icon_wallet, "#BDBDBD"),

//                ExpenseCategory(13, "Lương", R.drawable.icon_wallet, "#388E3C"),
//                ExpenseCategory(14, "Thưởng", R.drawable.icon_chart, "#7CB342"),
//                ExpenseCategory(15, "Kinh doanh", R.drawable.icon_wallet, "#8BC34A"),
//                ExpenseCategory(16, "Lãi đầu tư", R.drawable.icon_chart, "#689F38"),
//                ExpenseCategory(17, "Tiền hỗ trợ", R.drawable.icon_wallet, "#CDDC39"),
//                ExpenseCategory(18, "Khác", R.drawable.icon_chart, "#C8E6C9")
            )
        }
    }

}