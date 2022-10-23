package com.aroman.testexcercise4.ui.classesFragment.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroman.testexcercise4.databinding.RecyclerItemDetailedClassesBinding
import com.aroman.testexcercise4.domain.entities.ClassE

class DetailedClassesViewHolder(
    private val binding: RecyclerItemDetailedClassesBinding,
    private val onItemClick: (position: Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(classE: ClassE) {
        binding.apply {
            className.text = classE.className
            classTime.text = classE.classTime
            classTeacher.text = classE.teacherName
            if (classE.zoomIsActive) openInZoom.isEnabled = true
            openInZoom.setOnClickListener { onItemClick(layoutPosition) }
        }
    }

    companion object {
        fun create(parent: ViewGroup, onItemClick: (position: Int) -> Unit) =
            DetailedClassesViewHolder(
                RecyclerItemDetailedClassesBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                onItemClick
            )
    }
}