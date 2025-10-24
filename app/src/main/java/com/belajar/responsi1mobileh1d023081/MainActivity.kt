package com.belajar.responsi1mobileh1d023081


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.belajar.responsi1mobileh1d023081.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout() {
        binding.sejarahklub.let {
            it.imgIcon.setImageResource(R.drawable.ic_bola)
            it.tvLayout.setText("Club History")
        }
        binding.layoutHeadCoach.let {
            it.imgIcon.setImageResource(R.drawable.pelatih)
            it.tvLayout.setText("Head Coach")
        }
        binding.layoutTeamSquad.let {
            it.imgIcon.setImageResource(R.drawable.tim)
            it.tvLayout.setText("Team Squad")
        }
    }

    private fun initListener() {
        binding.sejarahklub.root.setOnClickListener {
            val intent = Intent(this, SejarahKlub::class.java)
            startActivity(intent)
        }
        binding.layoutHeadCoach.root.setOnClickListener {
            val intent = Intent(this, HeadCoachActivity::class.java)
            startActivity(intent)
        }
        binding.layoutTeamSquad.root.setOnClickListener {
            val intent = Intent(this, SquadActivity::class.java)
            startActivity(intent)
        }
    }
}