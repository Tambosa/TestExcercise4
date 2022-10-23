package com.aroman.testexcercise4.ui.classesFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aroman.testexcercise4.domain.SchoolRepository
import com.aroman.testexcercise4.domain.entities.ClassE
import com.aroman.testexcercise4.domain.entities.ExtraClassE
import kotlinx.coroutines.*

class ClassesViewModel(private val repo: SchoolRepository) : ViewModel() {
    private val _liveClasses: MutableLiveData<List<ClassE>> = MutableLiveData()
    val classesList: LiveData<List<ClassE>> = _liveClasses

    private val _liveExtraClasses: MutableLiveData<List<ExtraClassE>> = MutableLiveData()
    val extraClassesList: LiveData<List<ExtraClassE>> = _liveExtraClasses


    fun loadClasses() {
        viewModelCoroutineScope.launch { susLoadClasses() }
    }

    private suspend fun susLoadClasses() {
        withContext(Dispatchers.IO) {
            _liveClasses.postValue(repo.loadTodaysClasses())
        }
    }

    fun loadExtraClasses() {
        viewModelCoroutineScope.launch { susLoadExtraClasses() }
    }

    private suspend fun susLoadExtraClasses() {
        withContext(Dispatchers.IO) {
            _liveExtraClasses.postValue(repo.loadExtraClasses())
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