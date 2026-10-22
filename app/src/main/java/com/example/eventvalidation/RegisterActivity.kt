package com.example.eventvalidation

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPhone: EditText
    private lateinit var edtMsv: EditText
    private lateinit var edtClass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edtName = findViewById(R.id.edtName)
        edtEmail = findViewById(R.id.edtEmail)
        edtPhone = findViewById(R.id.edtPhone)
        edtMsv = findViewById(R.id.edtMsv)
        edtClass = findViewById(R.id.edtClass)

        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            if (validate()) {
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra("name", edtName.text.toString().trim())
                    putExtra("email", edtEmail.text.toString().trim())
                    putExtra("phone", edtPhone.text.toString().trim())
                    putExtra("msv", edtMsv.text.toString().trim())
                    putExtra("class", edtClass.text.toString().trim())
                }
                startActivity(intent)
            }
        }
    }

    private fun validate(): Boolean {
        val name = edtName.text.toString().trim()
        val email = edtEmail.text.toString().trim()
        val phone = edtPhone.text.toString().trim()
        val msv = edtMsv.text.toString().trim()
        val lop = edtClass.text.toString().trim()
        var ok = true

        if (name.isEmpty()) {
            edtName.error = "Họ tên không được để trống"; ok = false
        } else if (!Regex("^[\\p{L} ]{2,}$").matches(name)) {
            edtName.error = "Họ tên chỉ gồm chữ cái, tối thiểu 2 ký tự"; ok = false
        }

        if (email.isEmpty()) {
            edtEmail.error = "Email không được để trống"; ok = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.error = "Email không hợp lệ"; ok = false
        }

        if (phone.isEmpty()) {
            edtPhone.error = "Số điện thoại không được để trống"; ok = false
        } else if (!Regex("^(0|\\+84)\\d{9}$").matches(phone)) {
            edtPhone.error = "SĐT không hợp lệ (VD: 0912345678)"; ok = false
        }

        if (msv.isEmpty()) {
            edtMsv.error = "MSV không được để trống"; ok = false
        } else if (!Regex("^\\d{10,13}$").matches(msv)) {
            edtMsv.error = "MSV gồm 10-13 chữ số"; ok = false
        }

        // Lớp
        if (lop.isEmpty()) {
            edtClass.error = "Lớp không được để trống"; ok = false
        }

        return ok
    }
}