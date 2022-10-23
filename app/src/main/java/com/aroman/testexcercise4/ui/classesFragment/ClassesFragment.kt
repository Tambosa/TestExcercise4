package com.aroman.testexcercise4.ui.classesFragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aroman.testexcercise4.data.FakeSchoolRepoImpl
import com.aroman.testexcercise4.databinding.FragmentClassesBinding
import com.aroman.testexcercise4.domain.entities.ClassE
import com.aroman.testexcercise4.ui.classesFragment.recycler.DetailedClassesAdapter

class ClassesFragment : Fragment() {
    private var _binding: FragmentClassesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ClassesViewModel = ClassesViewModel(FakeSchoolRepoImpl())
    private val detailedClassesAdapter = DetailedClassesAdapter { position ->
        onItemClick(position)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClassesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClassesRecycler()
        initViewModel()
        loadData()
    }

    private fun initClassesRecycler() {
        binding.classesDetailsRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = detailedClassesAdapter
        }
    }

    private fun onItemClick(position: Int) {
        openZoom((detailedClassesAdapter.getData()[position] as ClassE).zoomLink)
    }

    private fun initViewModel() {
        viewModel.classesList.observe(viewLifecycleOwner) {
            detailedClassesAdapter.addData(it)
        }
        viewModel.extraClassesList.observe(viewLifecycleOwner) {
            detailedClassesAdapter.addData(it)
        }
    }

    private fun openZoom(zoomLink: Any) {
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

    private fun loadData() {
        viewModel.loadClasses()
        viewModel.loadExtraClasses()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
