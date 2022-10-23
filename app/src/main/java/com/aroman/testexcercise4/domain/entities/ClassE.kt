package com.aroman.testexcercise4.domain.entities

data class ClassE(
    val className: String,
    override val classTime: String,
    val zoomIsActive: Boolean,
    val zoomLink: String,
    val teacherName: String = ""
) : SchoolClass