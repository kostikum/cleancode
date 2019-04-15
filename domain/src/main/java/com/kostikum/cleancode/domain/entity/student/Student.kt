package com.kostikum.cleancode.domain.entity.student

import com.kostikum.cleancode.domain.entity.DomainEntity

data class Student(
    val id: String,
    val name: String,
    val age: Int,
    val imageUrl: String
) : DomainEntity