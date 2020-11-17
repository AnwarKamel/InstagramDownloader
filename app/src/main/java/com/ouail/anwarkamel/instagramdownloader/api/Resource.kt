package com.ouail.anwarkamel.instagramdownloader.api

sealed class Resource<out T> {
    data class Success<out T>(
        val response: T
    ): Resource<T>()

    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int,
        val errorMessage: String?
    ) : Resource<Nothing>()

}