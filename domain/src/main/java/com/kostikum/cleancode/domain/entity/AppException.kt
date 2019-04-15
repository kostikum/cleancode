package com.kostikum.cleancode.domain.entity

class AppException(
    val type: AppExceptionType = AppExceptionType.UNKNOWN
) : Throwable()