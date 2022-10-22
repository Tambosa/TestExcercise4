package com.aroman.testexcercise4.ui.data

import com.aroman.testexcercise4.ui.domain.SchoolRepository
import com.aroman.testexcercise4.ui.domain.entities.ClassE
import com.aroman.testexcercise4.ui.domain.entities.HomeworkE

class FakeSchoolRepoImpl: SchoolRepository {
    override suspend fun loadTodaysClasses(): List<ClassE> {
        return listOf(
            ClassE("History", "9:00 - 9:45", true, ""),
            ClassE("Math", "10:00 - 10:45", false, ""),
            ClassE("Russian", "11:00 - 11:45", false, ""),
            ClassE("Biology", "12:00 - 12:45", false, ""),
        )
    }

    override suspend fun loadAllHomework(): List<HomeworkE> {
        return listOf(
            HomeworkE(
                "Literature",
                "2 days",
                "Read scenes 1.1 - 1.42 of The Master and Margarita"
            ),
            HomeworkE("Math", "5 days", "Solve equations 12.1 - 12.5"),
        )
    }

    override suspend fun loadExamDate(): String {
        return "9 days 23 hours 59 minutes"
    }
}