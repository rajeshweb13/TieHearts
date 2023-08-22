package com.tiehearts.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tiehearts.R
import com.tiehearts.databinding.FragmentHomeBinding
import com.tiehearts.databinding.FragmentSplashBinding
import com.tiehearts.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : Fragment() {

    val viewModel: SplashViewModel by viewModels()

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as? AppCompatActivity)?.supportActionBar?.hide()
        //   activity?.findViewById<BottomNavigationView>(R.id.nav_view)!!.isVisible = false

        val navBar = activity?.findViewById<BottomNavigationView>(com.tiehearts.R.id.nav_view)
        navBar?.isVisible = false

        handleFragment()
    }

    private fun handleFragment() {
        Handler(Looper.getMainLooper()).postDelayed({
            if (viewModel.loggedIn || Utils.isLoggedIn) {
                findNavController().navigate(R.id.action_spalashFragment_to_homeFragment)
            } else {
                findNavController().navigate(R.id.action_spalashFragment_to_tutorialFragment)
            }
        },4000L)
    }
}