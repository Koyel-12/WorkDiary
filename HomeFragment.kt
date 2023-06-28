package com.example.workdiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        val layoutManager = StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL)
        recyclerView.layoutManager = layoutManager

        val items = getSampleItems()
        val adapter = CardViewAdapter(items)
        recyclerView.adapter = adapter

        return view
    }

    private fun getSampleItems(): List<CRUDOperationModel> {
        val sampleItems = mutableListOf<CRUDOperationModel>()
        sampleItems.add(CRUDOperationModel("Add Resources", R.drawable.addemployeeicon))
        sampleItems.add(CRUDOperationModel("Delete Resource", R.drawable.deleteemployeeicon))
        sampleItems.add(CRUDOperationModel("Edit Resource", R.drawable.editemployeeicon))
        sampleItems.add(CRUDOperationModel("View Resource", R.drawable.viewemployeeicon))
        sampleItems.add(CRUDOperationModel("Report Resource", R.drawable.reportemployeeicon))
        // Add more items as needed
        return sampleItems
    }
}