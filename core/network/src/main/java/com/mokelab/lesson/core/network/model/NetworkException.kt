package com.mokelab.lesson.core.network.model

class NetworkException(
    val status: Int,
    val body: String,
) : Exception("status=$status, body=$body")