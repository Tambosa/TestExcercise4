package com.aroman.testexcercise4.domain

import com.aroman.testexcercise4.domain.entities.ClassE
import com.aroman.testexcercise4.domain.entities.ExtraClassE
import com.aroman.testexcercise4.domain.entities.HomeworkE

interface SchoolRepository {
    suspend fun loadTodaysClasses(): List<ClassE>
    suspend fun loadExtraClasses(): List<ExtraClassE>
    suspend fun loadAllHomework(): List<HomeworkE>
    suspend fun loadExamDate(): String
}