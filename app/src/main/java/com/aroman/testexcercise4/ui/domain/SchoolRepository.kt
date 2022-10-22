package com.aroman.testexcercise4.ui.domain

import com.aroman.testexcercise4.ui.domain.entities.ClassE
import com.aroman.testexcercise4.ui.domain.entities.HomeworkE

interface SchoolRepository {
    suspend fun loadTodaysClasses(): List<ClassE>
    suspend fun loadAllHomework(): List<HomeworkE>
    suspend fun loadExamDate(): String
}