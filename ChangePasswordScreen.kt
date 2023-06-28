// ChangePasswordScreen.kt

package com.example.workdiary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth

class ChangePasswordScreen : AppCompatActivity() {
    private lateinit var currentPasswordEditText: TextInputEditText
    private lateinit var newPasswordEditText: TextInputEditText
    private lateinit var confirmPasswordEditText: TextInputEditText
    private lateinit var changePasswordButton: Button
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password_screen)

        currentPasswordEditText = findViewById(R.id.currentPassword)
        newPasswordEditText = findViewById(R.id.newPassword)
        confirmPasswordEditText = findViewById(R.id.confirmPassword)
        changePasswordButton = findViewById(R.id.btnChangePassword)

        firebaseAuth = FirebaseAuth.getInstance()

        changePasswordButton.setOnClickListener {
            val currentPassword = currentPasswordEditText.text.toString()
            val newPassword = newPasswordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (newPassword == confirmPassword) {
                val user = firebaseAuth.currentUser
                if (user != null) {
                    val credential = EmailAuthProvider.getCredential(user.email!!, currentPassword)
                    user.reauthenticate(credential).addOnCompleteListener { authTask ->
                        if (authTask.isSuccessful) {
                            user.updatePassword(newPassword).addOnCompleteListener { updateTask ->
                                if (updateTask.isSuccessful) {
                                    Toast.makeText(
                                        this,
                                        "Password updated successfully",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    val intent= Intent(this,LoginScreen::class.java)
                                    startActivity(intent)
                                } else {
                                    Toast.makeText(
                                        this,
                                        "Failed to update password",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        } else {
                            Toast.makeText(
                                this,
                                "Authentication failed. Please check your current password",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            } else {
                Toast.makeText(this, "New password and confirm password do not match", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
