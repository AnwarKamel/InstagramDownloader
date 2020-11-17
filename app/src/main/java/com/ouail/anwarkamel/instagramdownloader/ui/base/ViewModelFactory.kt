package com.ouail.anwarkamel.instagramdownloader.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ouail.anwarkamel.instagramdownloader.api.InstaRepository
import com.ouail.anwarkamel.instagramdownloader.ui.home.HomeViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: InstaRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository) as T
            else -> throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}