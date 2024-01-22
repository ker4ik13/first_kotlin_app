package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val linkToReg: TextView = findViewById(R.id.linkToRegistration)

        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Авторизация
        val userLogin: EditText = findViewById(R.id.inputUserNameAuth)
        val userPassword: EditText = findViewById(R.id.inputPasswordAuth)
        val buttonAuth: Button = findViewById(R.id.buttonAuthorization)

        buttonAuth.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if (login == "" || password == "") {
                Toast.makeText(this, "Не все поля заполнены!", Toast.LENGTH_LONG).show()
            }

            val db = DbHelper(this, null)
            val isAuth = db.getUser(login, password)

            if (isAuth) {
                Toast.makeText(this, "Пользователь $login авторизован", Toast.LENGTH_LONG).show()
                userLogin.text.clear()
                userPassword.text.clear()

                val intent = Intent(this, ItemsActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Пользователь $login не авторизован", Toast.LENGTH_LONG).show()
            }

        }
    }
}