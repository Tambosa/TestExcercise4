package com.aroman.testexcercise4.data

import com.aroman.testexcercise4.domain.SchoolRepository
import com.aroman.testexcercise4.domain.entities.ClassE
import com.aroman.testexcercise4.domain.entities.ExtraClassE
import com.aroman.testexcercise4.domain.entities.HomeworkE

class FakeSchoolRepoImpl : SchoolRepository {
    override suspend fun loadTodaysClasses(): List<ClassE> {
        return listOf(
            ClassE("History", "9:00 - 9:45", true, ""),
            ClassE("Math", "10:00 - 10:45", false, ""),
            ClassE("Biology", "12:00 - 12:45", false, ""),
            ClassE("Russian", "13:00 - 13:45", false, ""),
        )
    }

    override suspend fun loadExtraClasses(): List<ExtraClassE> {
        return listOf(
            ExtraClassE(
                "Physical Education",
                "11:00 - 11:45",
                "Intensive Preparation for the Junior World Championship in Los Angelos",
            )
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