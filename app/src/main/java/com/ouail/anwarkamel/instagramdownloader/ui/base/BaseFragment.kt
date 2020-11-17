package com.ouail.anwarkamel.instagramdownloader.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.ouail.anwarkamel.instagramdownloader.R
import com.ouail.anwarkamel.instagramdownloader.api.InstaRepository
import com.ouail.anwarkamel.instagramdownloader.api.MyApi
import kotlinx.android.synthetic.main.fragment_home.view.*

abstract class BaseFragment <VM: ViewModel, B: ViewBinding > : Fragment() {

    protected lateinit var binding: B
    protected lateinit var viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = getFragmentLayoutBinding(inflater, container).also {
        val api = MyApi()
        val repository = InstaRepository(api)
        val factory = ViewModelFactory(repository)

        viewModel= ViewModelProvider(this, factory).get(getViewModelClass())
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
         val toolbar = view.findViewById(R.id.toolbar) as Toolbar?
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
    }

    abstract fun getViewModelClass(): Class<VM>
    abstract fun getFragmentLayoutBinding(inflater: LayoutInflater, container: ViewGroup?): B
}