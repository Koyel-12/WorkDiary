package com.example.workdiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.FirebaseDatabase

class DeleteResourceScreen : AppCompatActivity() {
    private lateinit var editTextEmpId:TextInputEditText
    private lateinit var deleteButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_resource_screen)

        editTextEmpId=findViewById(R.id.empId)
        deleteButton=findViewById(R.id.deleteButton)
        deleteButton.setOnClickListener {
            deleteResourcesToDatabase()
        }
    }

    private fun deleteResourcesToDatabase() {
        val empId=editTextEmpId.text.toString()
        val database=FirebaseDatabase.getInstance()
        val resourceRef=database.getReference("resource")

        resourceRef.child(empId).removeValue()
            .addOnSuccessListener {
                Toast.makeText(this,"Resources are deleted successfully",Toast.LENGTH_SHORT).show()
                val intent= Intent(this,DashboardScreen::class.java)
                startActivity(intent)
            }
            .addOnFailureListener {
                Toast.makeText(this,"Resources are failed to deleted",Toast.LENGTH_SHORT).show()
            }
    }
}