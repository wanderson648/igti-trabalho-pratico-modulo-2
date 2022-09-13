package com.example.trabalhopratico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trabalhopratico.databinding.ActivityShowYourNameBinding

class ShowYourName : AppCompatActivity() {

  private lateinit var binding: ActivityShowYourNameBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityShowYourNameBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val bundle = intent.extras?.get("Name") as Bundle
    val user = bundle.get("user") as User
    binding.sentName.text = user.name

  }
}