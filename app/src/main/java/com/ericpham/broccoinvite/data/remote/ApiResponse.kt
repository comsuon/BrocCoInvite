package com.ericpham.broccoinvite.data.remote

import com.google.gson.Gson
import retrofit2.Response

//https://stackoverflow.com/a/56511000
sealed class ApiResponse<T> {
    companion object {
        fun <T> create(response: Response<T>): ApiResponse<T> {
            return if (response.isSuccessful) {
                val body = response.body()
                ApiSuccessResponse(body)
            } else {
                val msg = response.errorBody()?.string()
                val errorObj =try {
                    Gson().fromJson(msg, ErrorBody::class.java)
                } catch (e: Exception) {
                    null
                }

                val errorMessage = errorObj?.errorMessage ?: msg
                ApiErrorResponse(errorMessage ?: "Some thing went wrong, please try again.")
            }
        }
    }
}

class ApiSuccessResponse<T>(val data: T?) : ApiResponse<T>()
class ApiErrorResponse<T>(val errorMessage: String) : ApiResponse<T>()

data class ErrorBody (
    val errorMessage: String
)