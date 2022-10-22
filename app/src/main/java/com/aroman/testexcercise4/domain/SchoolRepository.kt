package com.aroman.testexcercise4.domain

import com.aroman.testexcercise4.domain.entities.ClassE
import com.aroman.testexcercise4.domain.entities.HomeworkE

interface SchoolRepository {
    suspend fun loadTodaysClasses(): List<ClassE>
    suspend fun loadAllHomework(): List<HomeworkE>
    suspend fun loadExamDate(): String
}