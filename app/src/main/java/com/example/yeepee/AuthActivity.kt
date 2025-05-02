package com.example.yeepee

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auth)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val userLogin: EditText = findViewById(R.id.userLoginAuth)
        val userPassword: EditText = findViewById(R.id.userPassAuth)
        val button: Button = findViewById(R.id.buttonAuth)


        val linkToReg: TextView = findViewById(R.id.linkToReg)

        linkToReg.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java) // this means context we are in
            startActivity(intent)
        }
        button.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if(login == "" || password == "")
                Toast.makeText(this,"Some parameters are empty", Toast.LENGTH_LONG).show()
            else
            {
                val db = DB_Helper(this,null)
                val isAuth = db.getUser(login, password)
                if (isAuth == true)
                {
                    Toast.makeText(this,"User $login authorized", Toast.LENGTH_LONG).show()

                    userLogin.text.clear()
                    userPassword.text.clear()

                    val intent = Intent(this, ItemActivity::class.java)
                    startActivity(intent)

                }else
                {
                    Toast.makeText(this,"User $login is not authorized", Toast.LENGTH_LONG).show()
                }
            }

            }
    }
}