package com.aroman.testexcercise4.ui.homeFragment.recyclers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroman.testexcercise4.databinding.RecyclerItemClassesBinding
import com.aroman.testexcercise4.ui.domain.entities.ClassE

class ClassesViewHolder(
    private val binding: RecyclerItemClassesBinding,
    private val onItemClick: (position: Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(classE: ClassE) {
        binding.apply {
            className.text = classE.className
            classTime.text = classE.classTime
            if (classE.zoomIsActive) openInZoom.isEnabled = true
            openInZoom.setOnClickListener { onItemClick(layoutPosition) }
        }
    }

    companion object {
        fun create(parent: ViewGroup, onItemClick: (position: Int) -> Unit): ClassesViewHolder =
            ClassesViewHolder(
                RecyclerItemClassesBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                onItemClick
            )
    }
}
