package com.ouail.anwarkamel.instagramdownloader.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ouail.anwarkamel.instagramdownloader.api.InstaRepository
import com.ouail.anwarkamel.instagramdownloader.api.Resource
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class HomeViewModel(
    private val repository: InstaRepository
) : ViewModel() {

    private val _instaInfo = MutableLiveData<Resource<ResponseBody>>()
    val instaInfo: LiveData<Resource<ResponseBody>>
        get() = _instaInfo

    fun getInstaInfo(url: String) = viewModelScope.launch {
        _instaInfo.value = repository.getInstaInfo(url)
    }
}