package com.aroman.testexcercise4.ui.homeFragment.recyclers

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroman.testexcercise4.domain.entities.ClassE

class ClassesAdapter(private val onItemClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<ClassesViewHolder>() {
    private var data: List<ClassE> = emptyList()

    fun getData() = data
    fun setData(classesList: List<ClassE>) {
        data = classesList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ClassesViewHolder.create(parent, onItemClick)

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}