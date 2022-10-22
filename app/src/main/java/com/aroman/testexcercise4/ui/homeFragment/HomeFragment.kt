package com.aroman.testexcercise4.ui.homeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aroman.testexcercise4.databinding.FragmentHomeBinding
import com.aroman.testexcercise4.ui.domain.entities.ClassE
import com.aroman.testexcercise4.ui.domain.entities.HomeworkE
import com.aroman.testexcercise4.ui.homeFragment.recyclers.ClassesAdapter
import com.aroman.testexcercise4.ui.homeFragment.recyclers.HomeworkAdapter

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val classesAdapter = ClassesAdapter { position ->
        onItemClick(position)
    }

    private val homeworkAdapter = HomeworkAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClassesRecycler()
        initHomeworkRecycler()
        homeworkAdapter.setData(
            listOf(
                HomeworkE(
                    "Literature",
                    "2 days",
                    "Read scenes 1.1 - 1.42 of The Master and Margarita"
                ),
                HomeworkE("Math", "5 days", "Solve equations 12.1 - 12.5"),
            )
        )
        classesAdapter.setData(
            listOf(
                ClassE("History", "9:00 - 9:45", true, ""),
                ClassE("Math", "10:00 - 10:45", false, ""),
                ClassE("Russian", "11:00 - 11:45", false, ""),
                ClassE("Biology", "12:00 - 12:45", false, ""),
            )
        )
    }

    private fun initClassesRecycler() {
        binding.classesRecycler.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = classesAdapter
        }
    }

    private fun onItemClick(position: Int) {
        openZoom(classesAdapter.getData()[position].zoomLink)
    }

    private fun openZoom(zoomLink: String) {
        //nothing
    }

    private fun initHomeworkRecycler() {
        binding.homeworkRecycler.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = homeworkAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}