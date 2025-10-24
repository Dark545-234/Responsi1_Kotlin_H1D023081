package com.belajar.responsi1mobileh1d023081

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.belajar.responsi1mobileh1d023081.databinding.ActivityHeadCoachBinding
import com.belajar.responsi1mobileh1d023081.viewmodel.MainViewModel

class HeadCoachActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeadCoachBinding
    private val viewModel: MainViewModel by viewModels()

    private val CLUB_ID = 582

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeadCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeViewModel()
        // Auto-fetch data saat activity dibuka
        viewModel.fetchCoach(CLUB_ID)
    }

    private fun observeViewModel() {
        viewModel.isLoading.observe(this) { isLoading ->
            binding.cardProfile.visibility = if (isLoading) View.GONE else View.VISIBLE
        }

        viewModel.coach.observe(this) { coach ->
            coach?.let {
                binding.tvHeadCoachName.text = it.name
                binding.tvHeadCoachDateOfBirth.text = "${it.dateOfBirth}"
                binding.tvHeadCoachNationality.text = "${it.nationality}"
            }
        }

        viewModel.error.observe(this) { error ->
            error?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        }
    }
}