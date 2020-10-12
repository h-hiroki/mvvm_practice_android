package com.example.mvvm_practice_android.ui.tasks.ui.Tasks

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.mvvm_practice_android.R
import com.example.mvvm_practice_android.ui.tasks.ui.addedittask.AddEditTaskActivity


class TasksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, TasksFragment())
            .commit()

        val addButton = findViewById<AppCompatButton>(R.id.addButton)
        addButton.setOnClickListener {
            val intent = Intent(application, AddEditTaskActivity::class.java)
            startActivity(intent)
        }
    }
}