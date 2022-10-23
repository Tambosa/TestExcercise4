package com.aroman.testexcercise4.ui.homeFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aroman.testexcercise4.domain.SchoolRepository
import com.aroman.testexcercise4.domain.entities.ClassE
import com.aroman.testexcercise4.domain.entities.HomeworkE
import kotlinx.coroutines.*

class HomeViewModel(private val repo: SchoolRepository) : ViewModel() {
    private val _liveClasses: MutableLiveData<List<ClassE>> = MutableLiveData()
    val classesList: LiveData<List<ClassE>> = _liveClasses

    private val _liveHomework: MutableLiveData<List<HomeworkE>> = MutableLiveData()
    val homeworkList: LiveData<List<HomeworkE>> = _liveHomework

    private val _liveExamDate: MutableLiveData<String> = MutableLiveData()
    val examDate: LiveData<String> = _liveExamDate

    fun loadClasses() {
        viewModelCoroutineScope.launch { susLoadClasses() }
    }

    private suspend fun susLoadClasses() {
        withContext(Dispatchers.IO) {
            _liveClasses.postValue(repo.loadTodaysClasses())
        }
    }

    fun loadHomework() {
        viewModelCoroutineScope.launch { susLoadHomework() }
    }

    private suspend fun susLoadHomework() {
        withContext(Dispatchers.IO) {
            _liveHomework.postValue(repo.loadAllHomework())
        }
    }

    fun loadExamDate() {
        viewModelCoroutineScope.launch { susLoadExamDate() }
    }

    private suspend fun susLoadExamDate() {
        withContext(Dispatchers.IO) {
            _liveExamDate.postValue(repo.loadExamDate())
        }
    }

    private val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        }
    )

    private fun handleError(error: Throwable) {
        //nothing
    }

    override fun onCleared() {
        super.onCleared()
        viewModelCoroutineScope.coroutineContext.cancel()
    }
}