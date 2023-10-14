package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){

            movie1.setOnClickListener {
                val intentToDetailActivity =
                    Intent(this@HomeActivity, DetailActivity::class.java)
                startActivity(intentToDetailActivity)
            }

            movie2.setOnClickListener {
                val intentToDetailActivity2 =
                    Intent(this@HomeActivity, DetailActivity2::class.java)
                startActivity(intentToDetailActivity2)
            }

            movie3.setOnClickListener {
                val intentToDetailActivity3 =
                    Intent(this@HomeActivity, DetailActivity3::class.java)
                startActivity(intentToDetailActivity3)
            }

            movie4.setOnClickListener {
                val intentToDetailActivity4 =
                    Intent(this@HomeActivity, DetailActivity4::class.java)
                startActivity(intentToDetailActivity4)
            }

            movie5.setOnClickListener {
                val intentToDetailActivity5 =
                    Intent(this@HomeActivity, DetailActivity5::class.java)
                startActivity(intentToDetailActivity5)
            }

            movie6.setOnClickListener {
                val intentToDetailActivity6 =
                    Intent(this@HomeActivity, DetailActivity6::class.java)
                startActivity(intentToDetailActivity6)
            }

            movie7.setOnClickListener {
                val intentToDetailActivity7 =
                    Intent(this@HomeActivity, DetailActivity7::class.java)
                startActivity(intentToDetailActivity7)
            }
        }
    }
}