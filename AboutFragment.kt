package com.example.workdiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_about, container, false)

        val headingTextView: TextView = rootView.findViewById(R.id.headingTextView)
        val descriptionTextView: TextView = rootView.findViewById(R.id.descriptionTextView)

        // Set the text for the TextViews
        headingTextView.text = "Welcome to Cooperate Brilliant App"
        descriptionTextView.text = "In this app, it is generally used for Admin portal in which it is used to perform various operation like add, edit, delete and update"

        return rootView
    }


}