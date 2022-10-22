package com.aroman.testexcercise4.ui.classesFragment.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroman.testexcercise4.databinding.RecyclerItemDetailedExtraClassesBinding
import com.aroman.testexcercise4.domain.entities.ExtraClassE

class DetailedExtraClassesViewHolder(
    private val binding: RecyclerItemDetailedExtraClassesBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(extraClassE: ExtraClassE) {
        binding.apply {
            className.text = extraClassE.className
            classTime.text = extraClassE.classTime
            classTeacher.text = extraClassE.teacherName
            classDescription.text = extraClassE.description
        }
    }

    companion object {
        fun create(parent: ViewGroup) = DetailedExtraClassesViewHolder(
            RecyclerItemDetailedExtraClassesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}