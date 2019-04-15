package com.kostikum.cleancode.domain.usecase.student

import com.kostikum.cleancode.domain.entity.student.Student

interface UpdateStudentUseCase {

    fun update(student: Student) : Boolean
}