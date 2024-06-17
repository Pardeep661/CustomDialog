package com.pardeep.customdialog

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    var cus_buttom :Button? = null
    var username : EditText? = null
    var password : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        cus_buttom = findViewById(R.id.custom_dialog)
        username = findViewById(R.id.editText1)
        password = findViewById(R.id.editText2)

        cus_buttom?.setOnClickListener {
            if (username?.text?.trim().isNullOrBlank()) {
                username?.error = "Please enter the name "
            }
            if (password?.text?.trim().isNullOrBlank()) {
                password?.error = "Please enter the password "

            } else {
                var dialog = Dialog(this).apply {
                   setContentView(R.layout.custom_dialog)
                    var confirm = findViewById<Button>(R.id.confirmbtn)
                    var back = findViewById<Button>(R.id.backbtn)
                    var cus_useraname = findViewById<EditText>(R.id.et_username)
                    var cus_password = findViewById<EditText>(R.id.et_password)
                    window?.setLayout(700, 450)

                    cus_useraname.setText(username?.text)
                    cus_password.setText(password?.text)

                    confirm.setOnClickListener{
                        dismiss()
                    }
                    back.setOnClickListener{
                        dismiss()
                    }

                    dismiss()

                }.show()
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}