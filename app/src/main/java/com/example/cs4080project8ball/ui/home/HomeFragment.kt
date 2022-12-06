package com.example.cs4080project8ball.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
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
    private lateinit var answers:List<String>

    //variables for GUI elements
    private lateinit var imgBtn:ImageButton
    private lateinit var answerText:TextView
    private lateinit var questionBox: EditText

    // when fragment is put into main activity
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]
        answers = HomeViewModel.answerBank

        // don't put anything here or app will crash on initialization

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    // before app starts, after view has been inflated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //initialize GUI elements
        imgBtn = btnAnswer
        answerText = tvAnswer
        questionBox = editText

        //initialize display
        answerText.text = HomeViewModel.lastAnswer

        imgBtn.setOnClickListener {
            var rand_answer = answers.random()
            answerText.text = rand_answer
            HomeViewModel.lastAnswer = rand_answer
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}