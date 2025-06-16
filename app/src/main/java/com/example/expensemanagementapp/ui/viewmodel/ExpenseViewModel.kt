package com.example.expensemanagementapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.expensemanagementapp.data.Expense
import com.example.expensemanagementapp.data.ExpenseDatabase
import kotlinx.coroutines.launch

class ExpenseViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = ExpenseDatabase.getDatabase(application).expenseDao()
    val allExpenses: LiveData<List<Expense>> = dao.getAllExpenses().asLiveData()

    fun deleteExpense(id: Int) = viewModelScope.launch {
        dao.deleteExpenseById(id)
    }

    fun addExpense(expense: Expense) = viewModelScope.launch {
        dao.insertExpense(expense)
    }
}
