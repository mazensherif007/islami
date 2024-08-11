package com.example.islami.ui.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentTasbehBinding

class TasbehFragment : Fragment() {

    lateinit var binding: FragmentTasbehBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasbehBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private val phrases = listOf("سبحان الله", "الحمد لله", "الله أكبر")

    private fun initViews() {

        val box = binding.box
        val sebha = binding.bodyOfSebha
        val tasbeh = binding.titleOfTasbeh
        var rotationAngle = 0f

        sebha.setOnClickListener {
            rotationAngle -= 10f
            sebha.rotation = rotationAngle
            val currentCount = box.text.toString().toInt()
            box.text = (currentCount + 1).toString()

            if (currentCount % 33 == 0) {
                val currentIndex = (currentCount / 33) % phrases.size
                tasbeh.text = phrases[currentIndex]
            }
        }
    }
}