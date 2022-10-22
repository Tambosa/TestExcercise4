package com.aroman.testexcercise4.domain.entities

data class ExtraClassE(
    val className: String,
    override val classTime: String,
    val teacherName: String,
    val description: String,
) : SchoolClass