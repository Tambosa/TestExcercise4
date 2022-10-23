package com.aroman.testexcercise4.ui.homeFragment.recyclers

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroman.testexcercise4.domain.entities.HomeworkE

class HomeworkAdapter : RecyclerView.Adapter<HomeworkViewHolder>() {
    private var data: List<HomeworkE> = emptyList()

    fun getData() = data
    fun setData(homeworkEList: List<HomeworkE>) {
        data = homeworkEList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeworkViewHolder.create(parent)

    override fun onBindViewHolder(holder: HomeworkViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}
