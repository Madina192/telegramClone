package com.example.telegram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.telegram.databinding.ActivityMainBinding
import com.example.telegram.ui.objects.AppDrawer
import com.example.telegram.ui.fragments.ChatsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mToolbar: Toolbar
    private lateinit var myAppDrawer: AppDrawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        setSupportActionBar(mToolbar)
        myAppDrawer.create()
        supportFragmentManager.beginTransaction()
            .add(R.id.data_container, ChatsFragment()).commit() //added fragment
    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        myAppDrawer = AppDrawer(this, mToolbar)
    }

}