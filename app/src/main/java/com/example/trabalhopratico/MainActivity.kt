package com.example.trabalhopratico

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.trabalhopratico.databinding.ActivityMainBinding
import java.io.Serializable

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)


    binding.button.setOnClickListener {
      val edText =  binding.editText.text.toString()

      if(edText.isEmpty()) {

        AlertDialog.Builder(this)
            .setTitle(getString(R.string.error))
            .setPositiveButton(android.R.string.ok) { dialog, which -> }
        .create()
        .show()
        return@setOnClickListener


      } else {
        val user = User(edText)
        val bundle = Bundle()
        bundle.putSerializable("user", user)

        startActivity(Intent(
          this,
          ShowYourName::class.java
        ).putExtra("Name", bundle))
      }
    }
  }
}

data class User(
  val name: String
): Serializable