package com.example.expensemanagementapp.ui.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.expensemanagementapp.R
import com.example.expensemanagementapp.data.Expense
import com.example.expensemanagementapp.data.ExpenseCategory
import com.example.expensemanagementapp.ui.viewmodel.ExpenseViewModel
import com.example.expensemanagementapp.util.IncomeData
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.Calendar

class IncomeFragment : Fragment() {

    private lateinit var gridLayout: GridLayout
    private lateinit var data: List<ExpenseCategory>
    private lateinit var viewModel: ExpenseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_expense, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gridLayout = view.findViewById(R.id.gridLayout)
        data = IncomeData.data()

        data.forEach { category ->
            val itemView =
                LayoutInflater.from(context).inflate(R.layout.item_category, gridLayout, false)
                    .apply {
                        findViewById<TextView>(R.id.name).text = category.name
                        findViewById<ImageView>(R.id.icon).setImageResource(category.iconResId)

                        layoutParams = GridLayout.LayoutParams().apply {
                            width = 0
                            height = ViewGroup.LayoutParams.WRAP_CONTENT
                            columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                            setMargins(16, 16, 16, 16)
                        }

                        setOnClickListener { showExpenseDialog(category) }
                    }
            gridLayout.addView(itemView)
        }
    }

    private fun showExpenseDialog(category: ExpenseCategory) {
        val dialogView = layoutInflater.inflate(R.layout.bottom_sheet_expense, null)
        val inputExpense = dialogView.findViewById<EditText>(R.id.inputNameExpense)
        val inputCalendar = dialogView.findViewById<EditText>(R.id.inputCalendarExpense)
        val inputCost = dialogView.findViewById<EditText>(R.id.inputCostExpense)
        val inputNote = dialogView.findViewById<EditText>(R.id.inputNoteExpense)
        val btnCalendar = dialogView.findViewById<ImageView>(R.id.btn_Calendar)
        val btnSubmit = dialogView.findViewById<Button>(R.id.btn_submit)

        inputExpense.setText(category.name)

        btnCalendar.setOnClickListener {
            showDatePicker { selectedDate ->
                inputCalendar.setText(selectedDate)
            }
        }

        BottomSheetDialog(requireContext()).apply {
            setContentView(dialogView)
            setCancelable(true)
            show()
        }

        btnSubmit.setOnClickListener {
            viewModel = ViewModelProvider(this)[ExpenseViewModel::class.java]
            val newExpense = Expense(
                name = inputExpense.text.toString(),
                cost = inputCost.text.toString(),
                type = "income",
                date = inputCalendar.text.toString(),
                note = inputNote.text.toString()
            )
            viewModel.addExpense(newExpense)
            Toast.makeText(requireContext(), "Thêm thành công!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showDatePicker(onDateSelected: (String) -> Unit) {
        val calendar = Calendar.getInstance()
        DatePickerDialog(
            requireContext(),
            { _, year, month, day ->
                onDateSelected("$day/${month + 1}/$year")
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }
}