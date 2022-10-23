package com.aroman.testexcercise4.ui.classesFragment.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroman.testexcercise4.domain.entities.ClassE
import com.aroman.testexcercise4.domain.entities.ExtraClassE
import com.aroman.testexcercise4.domain.entities.SchoolClass

class DetailedClassesAdapter(private val onItemClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var data: ArrayList<SchoolClass> = arrayListOf()

    fun getData() = data
    fun addData(classesList: List<SchoolClass>) {
        data.addAll(classesList)
        sortByTime(data)
        notifyDataSetChanged()
    }

    private fun sortByTime(data: ArrayList<SchoolClass>) {
        data.sortWith(compareBy<SchoolClass> { "${it.classTime[0]}${it.classTime[1]}".toInt() }.thenBy {
            "${it.classTime[3]}${it.classTime[4]}".toInt() })
    }

    override fun getItemViewType(position: Int): Int {
        return if (data[position] is ClassE) CLASS
        else {
            EXTRA_CLASS
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            CLASS -> DetailedClassesViewHolder.create(parent, onItemClick)
            else -> DetailedExtraClassesViewHolder.create(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            CLASS -> (holder as DetailedClassesViewHolder).bind(data[position] as ClassE)
            EXTRA_CLASS -> (holder as DetailedExtraClassesViewHolder).bind(data[position] as ExtraClassE)
        }
    }

    override fun getItemCount() = data.size

    companion object {
        const val CLASS = 0
        const val EXTRA_CLASS = 1
    }
}