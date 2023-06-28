package com.example.workdiary



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class ForgetPasswordScreen : AppCompatActivity() {
    private lateinit var emailEditText: TextInputEditText
    private lateinit var resetButton: Button
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password_screen)

        emailEditText = findViewById(R.id.email)
        resetButton = findViewById(R.id.btnReset)

        firebaseAuth = FirebaseAuth.getInstance()

        resetButton.setOnClickListener {
            val email = emailEditText.text.toString()

            if (email.isNotEmpty()) {
                firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Password reset email sent", Toast.LENGTH_SHORT).show()
                        val intent= Intent(this,ChangePasswordScreen::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Failed to send password reset email", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
