package com.ugi.allinone.todolistapp

import android.os.Bundle
import com.ugi.allinone.R
import com.ugi.allinone.main.BaseActivity

class TodoListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)
    }
}