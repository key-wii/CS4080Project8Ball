package com.example.cs4080project8ball.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cs4080project8ball.R
import com.example.cs4080project8ball.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this)[GalleryViewModel::class.java]

        val view: View = inflater.inflate(R.layout.fragment_gallery, container, false)
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}