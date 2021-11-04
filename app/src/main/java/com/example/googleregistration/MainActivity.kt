package com.example.googleregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.googleregistration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.next.setOnClickListener { registration() }
    }


    private fun registration() {
        val firstName = binding.firstNameInput.text.toString()
        val lastName = binding.lastNameInput.text.toString()
        val email = binding.userNameInput.text.toString()
        val password = binding.passwordInput.text.toString()
        val confirm = binding.confirmInput.text.toString()

        if (firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirm.isNotEmpty()) {
            if (email.contains('!') || email.contains('@')||email.contains(' ') || email.contains('#')
                || email.contains('$')||email.contains('%') || email.contains('^')
                || email.contains('&')||email.contains('*') || email.contains('?')
                || email.contains('>')||email.contains('-') || email.contains('_') ){
              //  binding.result.setText("Please Enter User Name Without Symbol or spaces")
                Toast.makeText(this, "Please Enter User Name Without Symbol or spaces", Toast.LENGTH_SHORT).show()

            }
           else if (password == confirm  ) {
                binding.result.setText("Hi ${firstName}@gmail.com you register successfully")

            } else {
                Toast.makeText(this, "Password Missmatch", Toast.LENGTH_SHORT).show()
                 //   binding.result.setText("Password Missmatch")
            }

        } else {
            Toast.makeText(this, "Please full all blanks", Toast.LENGTH_SHORT).show()

        }

    }
}

