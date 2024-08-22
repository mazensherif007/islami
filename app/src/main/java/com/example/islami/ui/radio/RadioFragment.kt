package com.example.islami.ui.radio

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.databinding.FragmentRadioBinding

class RadioFragment : Fragment() {

    private lateinit var binding: FragmentRadioBinding
    var radioService: RadioService? = null
    var bound = false
    private lateinit var radioList: List<Radio>
    private var currentRadioIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRadioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getRadioList()
        initViews()
        onPlayClick()
        onPreviousClick()
        onNextClick()
    }

    private fun onNextClick() {
        binding.forwardBtn.setOnClickListener {
            pauseMediaPlayer()
            binding.playStopButton.setImageResource(R.drawable.baseline_play_arrow2_24)
            currentRadioIndex =
                if (currentRadioIndex == radioList.size - 1) 0 else ++currentRadioIndex
            radioService?.initMediaPlayer(
                radioList[currentRadioIndex].url,
                radioList[currentRadioIndex].name
            )
            binding.radioText.text = radioList[currentRadioIndex].name
        }
    }

    private fun onPreviousClick() {
        binding.backBtn.setOnClickListener {
            pauseMediaPlayer()
            binding.playStopButton.setImageResource(R.drawable.baseline_play_arrow2_24)
            currentRadioIndex =
                if (currentRadioIndex == 0) radioList.size - 1 else --currentRadioIndex
            radioService?.initMediaPlayer(
                radioList[currentRadioIndex].url,
                radioList[currentRadioIndex].name
            )
            binding.radioText.text = radioList[currentRadioIndex].name
        }
    }

    private fun onPlayClick() {
        binding.playStopButton.setOnClickListener {
            radioService?.let { radioService ->
                if (!radioService.getIsPlaying()) {
                    radioService.startMediaPlayer()
                    binding.playStopButton.setImageResource(R.drawable.baseline_pause_24)
                } else {
                    pauseMediaPlayer()
                    binding.playStopButton.setImageResource(R.drawable.baseline_play_arrow2_24)
                }
            }
        }
    }

    private fun pauseMediaPlayer() {
        if (bound) {
            radioService?.playPauseMediaPlayer()
        }
    }

    private fun initViews() {
        binding.radioText.text = radioList[currentRadioIndex].name
        radioService?.initMediaPlayer(
            radioList[currentRadioIndex].url,
            radioList[currentRadioIndex].name
        )
    }

    private fun getRadioList() {
        radioList = listOf(
            Radio(
                "إذاعة عبدالباسط عبدالصمد",
                "https://backup.qurango.net/radio/abdulbasit_abdulsamad_mojawwad"
            ),
            Radio(
                "إذاعة محمد صديق المنشاوي",
                "https://backup.qurango.net/radio/mohammed_siddiq_alminshawi_mojawwad"
            ),
            Radio(
                "إذاعة محمود خليل الحصري",
                "https://backup.qurango.net/radio/mahmoud_khalil_alhussary_mojawwad"
            )
        )
    }

    override fun onStart() {
        super.onStart()
        bindService()
        startService()
    }

    private fun startService() {
        val intent = Intent(requireActivity(), RadioService::class.java)
        requireActivity().startService(intent)
    }

    private fun bindService() {
        val intent = Intent(requireContext(), RadioService::class.java)
        requireContext().bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as RadioService.MyBinder
            radioService = binder.getService()
            bound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            radioService = null
            bound = false
        }
    }

    override fun onStop() {
        super.onStop()
        requireActivity().unbindService(connection)
    }
}
