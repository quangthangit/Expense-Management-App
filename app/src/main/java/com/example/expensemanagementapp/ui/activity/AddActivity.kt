package com.example.expensemanagementapp.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.expensemanagementapp.R
import com.example.expensemanagementapp.ui.fragment.ExpenseFragment
import com.example.expensemanagementapp.ui.fragment.IncomeFragment

class AddActivity : AppCompatActivity() {

    private lateinit var btnBack : ImageView
    private lateinit var btnExpense : Button
    private lateinit var btnIncome : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnBack = findViewById(R.id.btn_back)
        btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        btnExpense = findViewById(R.id.btn_expense)
        btnIncome = findViewById(R.id.btn_income)

        btnExpense.setOnClickListener {
            replaceFragment(ExpenseFragment())
        }

        btnIncome.setOnClickListener {
            replaceFragment(IncomeFragment())
        }

        replaceFragment(ExpenseFragment())
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.addLayout, fragment)
        fragmentTransaction.commit()
    }
}