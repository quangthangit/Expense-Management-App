package com.example.expensemanagementapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.expensemanagementapp.R
import com.example.expensemanagementapp.ui.fragment.HomeFragment
import com.example.expensemanagementapp.ui.fragment.UserFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var btnAdd : ImageButton
    private lateinit var btnUser : ImageView
    private lateinit var btnHome : ImageView
    private lateinit var btnChart : ImageView
    private lateinit var btnWallet : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnAdd = findViewById(R.id.btn_add)

        btnHome = findViewById(R.id.menu_home)
        btnChart = findViewById(R.id.menu_chart)
        btnWallet = findViewById(R.id.menu_wallet)
        btnUser = findViewById(R.id.menu_user)
        btnUser.setOnClickListener {
            replaceFragment(UserFragment())
        }

        btnHome.setOnClickListener {
            replaceFragment(HomeFragment())
        }

        btnAdd.setOnClickListener {
            startActivity(Intent(this,AddActivity::class.java))
        }
        replaceFragment(HomeFragment())
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.homeLayout, fragment)
        fragmentTransaction.commit()
    }
}