package com.tiehearts.ui.mobile

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.ColorUtils
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tiehearts.R
import com.tiehearts.databinding.FragmentMobileBinding


class MobileFragment : Fragment() {

    private var _binding: FragmentMobileBinding?= null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMobileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as? AppCompatActivity)?.supportActionBar?.hide()

        //   activity?.findViewById<BottomNavigationView>(R.id.nav_view)!!.isVisible = false

        val navBar = activity?.findViewById<BottomNavigationView>(com.tiehearts.R.id.nav_view)
        navBar?.isVisible = false

        binding.apply {
            backButton.setOnClickListener {
                (requireActivity() as? AppCompatActivity)?.onBackPressedDispatcher?.onBackPressed()
            }

            getopt.setOnClickListener {
                findNavController().navigate(R.id.action_mobileFragment_to_otpFragment)
            }

        }
    }


}