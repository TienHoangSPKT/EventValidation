package com.example.eventvalidation

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        findViewById<TextView>(R.id.tvName).text = "Họ tên: ${intent.getStringExtra("name")}"
        findViewById<TextView>(R.id.tvEmail).text = "Email: ${intent.getStringExtra("email")}"
        findViewById<TextView>(R.id.tvPhone).text = "SĐT: ${intent.getStringExtra("phone")}"
        findViewById<TextView>(R.id.tvMsv).text = "MSV: ${intent.getStringExtra("msv")}"
        findViewById<TextView>(R.id.tvClass).text = "Lớp: ${intent.getStringExtra("class")}"

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            startActivity(android.content.Intent(this, RegisterActivity::class.java))
        }
    }
}