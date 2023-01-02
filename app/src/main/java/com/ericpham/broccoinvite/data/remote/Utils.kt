package com.ericpham.broccoinvite.data.remote

import retrofit2.Response

suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): ApiResponse<T> {
    return try {
        val response = call.invoke()
        ApiResponse.create(response)
    } catch (error: Throwable) {
        ApiErrorResponse("Some thing went wrong, please try again.")
    }
}