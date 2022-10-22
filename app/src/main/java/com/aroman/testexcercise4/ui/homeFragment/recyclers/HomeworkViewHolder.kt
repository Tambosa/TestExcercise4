package com.aroman.testexcercise4.ui.homeFragment.recyclers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroman.testexcercise4.databinding.RecyclerItemHomeworkBinding
import com.aroman.testexcercise4.ui.domain.entities.HomeworkE

class HomeworkViewHolder(private val binding: RecyclerItemHomeworkBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(homeworkE: HomeworkE) {
        binding.apply {
            homeworkName.text = homeworkE.className
            homeworkDeadline.text = homeworkE.deadline
            homeworkDescription.text = homeworkE.description
        }
    }

    companion object {
        fun create(parent: ViewGroup): HomeworkViewHolder =
            HomeworkViewHolder(
                RecyclerItemHomeworkBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
            )
    }
}
