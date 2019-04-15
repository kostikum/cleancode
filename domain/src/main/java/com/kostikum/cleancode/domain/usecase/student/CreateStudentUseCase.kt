package com.kostikum.cleancode.domain.usecase.student

import com.kostikum.cleancode.domain.entity.student.CreateStudent

interface CreateStudentUseCase {

    fun create(student: CreateStudent) : Boolean
}