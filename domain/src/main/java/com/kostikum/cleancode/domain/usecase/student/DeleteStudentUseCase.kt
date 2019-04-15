package com.kostikum.cleancode.domain.usecase.student

interface DeleteStudentUseCase {

    fun delete(id: String) : Boolean
}