package com.kostikum.cleancode.domain.usecase.student

import com.kostikum.cleancode.domain.entity.student.SearchParams
import com.kostikum.cleancode.domain.entity.student.Student

interface SearchStudentUseCase {

    fun search(params: SearchParams) : List<Student>
}