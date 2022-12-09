package com.example.cs4080project8ball.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cs4080project8ball.R
import com.example.cs4080project8ball.databinding.FragmentGalleryBinding
import com.example.cs4080project8ball.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // GUI variables
    private lateinit var addbox:EditText
    private lateinit var addBtn:Button

    private lateinit var viewModel:HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        addbox = addAnswer
        addBtn = addButton
        addBtn.setOnClickListener{
            //get text from editText box
            val input:String = addAnswer.text.toString()

            //check if empty string
            if(input.trim().isNotEmpty()){
                HomeViewModel.addAnswer(input.trim())   //add to answer bank
                addbox.setText("")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}