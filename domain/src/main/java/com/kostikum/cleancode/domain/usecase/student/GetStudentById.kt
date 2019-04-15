package com.kostikum.cleancode.domain.usecase.student

import com.kostikum.cleancode.domain.entity.student.Student

interface GetStudentById {

    fun get(id: String) : Student
}