package com.kostikum.cleancode.data.repository

import java.io.BufferedReader
import java.io.InputStreamReader

object JsonUtil {

    const val NORMAL_RESPONSE = "normal_response.json"
    const val ERROR_RESPONSE = "error_response.json"

    fun getJson(path: String) : String {
        val jsonInput = JsonUtil::class.java.classLoader.getResourceAsStream("api/$path")

        return BufferedReader(InputStreamReader(jsonInput)).use {
            it.readText()
        }
    }






}