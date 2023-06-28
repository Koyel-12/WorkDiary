package com.example.workdiary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.FirebaseDatabase

class AddResourceScreen : AppCompatActivity() {
    private lateinit var editTextEmpId: TextInputEditText
    private lateinit var editTextName: TextInputEditText
    private lateinit var editTextProjectId: TextInputEditText
    private lateinit var editTextDepartment: TextInputEditText
    private lateinit var editTextPerformance: TextInputEditText
    private lateinit var editTextAddress: TextInputEditText
    private lateinit var editTextExperience: TextInputEditText
    private lateinit var editTextCategory: TextInputEditText
    private lateinit var editTextSalary: TextInputEditText
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_resource_screen)

        editTextEmpId = findViewById(R.id.empId)
        editTextName = findViewById(R.id.name)
        editTextProjectId = findViewById(R.id.projectId)
        editTextDepartment = findViewById(R.id.department)
        editTextPerformance = findViewById(R.id.performance)
        editTextAddress = findViewById(R.id.address)
        editTextExperience = findViewById(R.id.experience)
        editTextCategory = findViewById(R.id.category)
        editTextSalary = findViewById(R.id.salary)
        addButton = findViewById(R.id.addButton)

        addButton.setOnClickListener {
            addResourceToDatabase()
        }
    }

    private fun addResourceToDatabase() {
        val empId = editTextEmpId.text.toString()
        val name = editTextName.text.toString()
        val projectId = editTextProjectId.text.toString()
        val department = editTextDepartment.text.toString()
        val performance = editTextPerformance.text.toString()
        val address = editTextAddress.text.toString()
        val experience = editTextExperience.text.toString()
        val category = editTextCategory.text.toString()
        val salary = editTextSalary.text.toString()

        val resource = Resource(empId, name, projectId, department, performance, address, experience, category, salary)

        val database = FirebaseDatabase.getInstance()
        val resourceRef = database.getReference("resource")

        val newResourceRef = resourceRef.push()
        newResourceRef.setValue(resource)
            .addOnSuccessListener {
                Toast.makeText(this, "Resource added successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, DashboardScreen::class.java)
                startActivity(intent)
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to add resource", Toast.LENGTH_SHORT).show()
            }
    }
}
