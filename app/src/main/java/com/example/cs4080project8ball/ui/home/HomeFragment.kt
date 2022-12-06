package com.example.cs4080project8ball.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cs4080project8ball.R
import com.example.cs4080project8ball.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // variables for behind the scenes data
    private lateinit var homeViewModel:HomeViewModel
    private lateinit var answer:List<String>

    //variables for GUI elements
    private var imgBtn = btnAnswer
    private var answerText = tvAnswer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        // inflates layout for fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.apply {

            // put code here?

            return view
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}