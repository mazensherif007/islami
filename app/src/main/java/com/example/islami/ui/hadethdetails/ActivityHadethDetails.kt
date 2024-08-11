package com.example.islami.ui.hadethdetails

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.databinding.ActivityHadethDetailsBinding
import com.example.islami.ui.hadeth.Hadeth

class ActivityHadethDetails : AppCompatActivity() {

    private lateinit var binding: ActivityHadethDetailsBinding
    var hadeth: Hadeth? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        readExtras()
        initViews()
    }

    private fun initViews() {
        title = null
        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding.chapterTitle.text = hadeth?.title
        binding.content.content.text = hadeth?.content
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun readExtras() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getParcelableExtra(EXTRA_HADETH, Hadeth::class.java)
        } else {
            hadeth = intent.getParcelableExtra(EXTRA_HADETH) as Hadeth?
        }
    }

    companion object {
        const val EXTRA_HADETH = "hadeth"
    }
}