package com.ouail.anwarkamel.instagramdownloader.api

class InstaRepository (
    private val  api: MyApi
): BaseRepository() {

    suspend fun getInstaInfo(url: String) = safeApiCall {
        api.getInstaPostInfo(url)
    }

}