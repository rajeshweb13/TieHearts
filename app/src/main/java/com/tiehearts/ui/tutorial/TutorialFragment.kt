package com.tiehearts.ui.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator
import com.tiehearts.R
import com.tiehearts.adapter.TutorialAdapter
import com.tiehearts.databinding.FragmentTutorialBinding


class TutorialFragment : Fragment() {

    private var _binding: FragmentTutorialBinding?= null
    private val binding get() = _binding!!
    private var currentPagePosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTutorialBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as? AppCompatActivity)?.supportActionBar?.hide()
        //   activity?.findViewById<BottomNavigationView>(R.id.nav_view)!!.isVisible = false

        val navBar = activity?.findViewById<BottomNavigationView>(com.tiehearts.R.id.nav_view)
        navBar?.isVisible = false

        val listTutrialImages = resources.obtainTypedArray(com.tiehearts.R.array.tut_images)
        val listHeader = resources.getStringArray(com.tiehearts.R.array.tut_header)
        val listDesc = resources.getStringArray(com.tiehearts.R.array.tut_desc)

        binding.apply {
            val adapter = TutorialAdapter(listTutrialImages,listHeader,listDesc,requireContext())
            tutorialPager.adapter = adapter
            tutorialPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
//            tutorialPager.beginFakeDrag()
//            tutorialPager.fakeDragBy(-10f)
//            tutorialPager.endFakeDrag()
        }

        TabLayoutMediator(binding.tabLayout, binding.tutorialPager)
        { tab, position ->}.attach()


        binding.rightButton.setOnClickListener {
            currentPagePosition = binding.tutorialPager.currentItem+1
            binding.tutorialPager.setCurrentItem(binding.tutorialPager.currentItem +1,true)
            if (currentPagePosition > 4) {
                findNavController().navigate(R.id.action_tutorialFragment_to_mobileFragment)
            }
        }

        binding.leftButton.setOnClickListener {
            binding.tutorialPager.setCurrentItem(binding.tutorialPager.currentItem -1,true)
        }

    }

}