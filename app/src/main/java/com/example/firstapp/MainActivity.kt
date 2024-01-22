package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linkToAuth: TextView = findViewById(R.id.linkToAuth)

        linkToAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        // Регистрация
        val userLogin: EditText = findViewById(R.id.inputUserNameReg)
        val userEmail: EditText = findViewById(R.id.inputEmailReg)
        val userPassword: EditText = findViewById(R.id.inputPasswordReg)
        val buttonReg: Button = findViewById(R.id.buttonRegistration)

        buttonReg.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if (login == "" || email == "" || password == "") {
                Toast.makeText(this, "Не все поля заполнены!", Toast.LENGTH_LONG).show()
            }

            val user = User(login, email, password)
            val db = DbHelper(this, null)
            db.addUser(user)

            Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()
            userLogin.text.clear()
            userEmail.text.clear()
            userPassword.text.clear()

            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

//        // TODO: вынести в отдельную функцию
//        val listView = findViewById<ListView>(R.id.todos_list)
//        val todoInput = findViewById<EditText>(R.id.todo_input)
//        val addButton = findViewById<Button>(R.id.addButton)
//
//        val todos: MutableList<String> = mutableListOf()
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
//        listView.adapter = adapter
//
//        // remove todo
//        listView.setOnItemClickListener { parent, view, position, id ->
//            val removeTodo = listView.getItemAtPosition(position).toString()
//            adapter.remove(removeTodo)
//            Toast.makeText(this, "Объект '$removeTodo' удален", Toast.LENGTH_SHORT).show()
//        }
//
//        // add todo
//        addButton.setOnClickListener {
//            val text = todoInput.text.toString().trim()
//
//            if (text != "") {
//                Toast.makeText(this, "Добавлено дело $text", Toast.LENGTH_SHORT).show()
//                adapter.insert(text, 0)
//                todoInput.setText("")
//            }
//        }
    }
}