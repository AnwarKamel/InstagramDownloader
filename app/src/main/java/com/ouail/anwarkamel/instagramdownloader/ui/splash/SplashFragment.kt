package com.ouail.anwarkamel.instagramdownloader.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController

import com.ouail.anwarkamel.instagramdownloader.R
import kotlinx.android.synthetic.main.fragment_splash.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startAnimation()

        viewLifecycleOwner.lifecycleScope.launch {
            delay(4000)
            findNavController().also {
                it.popBackStack()
                    it.navigate(R.id.homeFragment)
            }
        }

    }

    private fun startAnimation() {
       //val ttb = AnimationUtils.loadAnimation(context, R.anim.ttb)
        val btt = AnimationUtils.loadAnimation(context, R.anim.btt)
//        val btt2 = AnimationUtils.loadAnimation(context, R.anim.btt2)
//        val btt3 = AnimationUtils.loadAnimation(context, R.anim.btt3)
//        val stb = AnimationUtils.loadAnimation(context, R.anim.stb)
        val zoom = AnimationUtils.loadAnimation(context, R.anim.zoom_in)

        // set Animation
        imageView.startAnimation(zoom)
        textView.startAnimation(btt)

    }

}
