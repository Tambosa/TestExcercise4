package com.aroman.testexcercise4.ui.homeFragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aroman.testexcercise4.data.FakeSchoolRepoImpl
import com.aroman.testexcercise4.databinding.FragmentHomeBinding
import com.aroman.testexcercise4.ui.homeFragment.recyclers.ClassesAdapter
import com.aroman.testexcercise4.ui.homeFragment.recyclers.HomeworkAdapter


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel = HomeViewModel(FakeSchoolRepoImpl())
    private val homeworkAdapter = HomeworkAdapter()
    private val classesAdapter = ClassesAdapter { position ->
        onItemClick(position)
    }

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
        initViewModel()
        loadData()
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
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("zoomus://${zoomLink}"))
        try {
            startActivity(intent)
        } catch (e: Exception) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=us.zoom.videomeetings")
                )
            )
        }
    }

    private fun initHomeworkRecycler() {
        binding.homeworkRecycler.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = homeworkAdapter
        }
    }

    private fun initViewModel() {
        viewModel.classesList.observe(viewLifecycleOwner) {
            classesAdapter.setData(it)
            binding.classesRecycler.scrollToPosition(classesAdapter.findFirstActiveClass())
        }
        viewModel.homeworkList.observe(viewLifecycleOwner) {
            homeworkAdapter.setData(it)
        }
        viewModel.examDate.observe(viewLifecycleOwner) {
            binding.cardTimerTextView.text = it
        }
    }

    private fun loadData() {
        viewModel.loadClasses()
        viewModel.loadHomework()
        viewModel.loadExamDate()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}