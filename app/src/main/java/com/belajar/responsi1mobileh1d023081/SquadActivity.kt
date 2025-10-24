package com.belajar.responsi1mobileh1d023081


import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.belajar.responsi1mobileh1d023081.adapter.SquadAdapter
import com.belajar.responsi1mobileh1d023081.data.model.Squad
import com.belajar.responsi1mobileh1d023081.databinding.ActivitySquadBinding
import com.belajar.responsi1mobileh1d023081.fragment.SquadDetailFragment
import com.belajar.responsi1mobileh1d023081.viewmodel.MainViewModel

class SquadActivity : AppCompatActivity(), SquadAdapter.OnSquadClickListener {
    private val CLUB_ID = 582
    private lateinit var binding: ActivitySquadBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var squadAdapter: SquadAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySquadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        observeViewModel()
        viewModel.fetchSquad(CLUB_ID)
    }

    private fun setupRecyclerView() {
        squadAdapter = SquadAdapter(this)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@SquadActivity)
            adapter = squadAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.squad.observe(this) { squadList ->
            squadAdapter.submitList(squadList)
        }
        viewModel.error.observe(this) { error ->
            error?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSquadClick(squad: Squad) {
        SquadDetailFragment.newInstance(
            squadName = squad.name,
            dateOfBirth = squad.dateOfBirth,
            nationality = squad.nationality,
            position = squad.position
        ).show(supportFragmentManager, SquadDetailFragment::class.java.simpleName)
    }
}