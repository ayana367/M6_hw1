package com.example.m6_hw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.m6_hw1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        binding.btnHand.setOnClickListener {
            if (binding.edtTitle.text.isEmpty()) {
                Toast.makeText(
                    this,
                    getString(R.string.the_text_is_empty_enter_the_text),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val i = Intent(this, RecipientActivity::class.java)
                i.putExtra(HAND_OVER, binding.edtTitle.text.toString())
                startForResult.launch(i)
            }
        }
    }

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                binding.edtTitle.setText(result.data?.getStringExtra(GET))
            }
        }

    companion object {
        const val HAND_OVER = "data"
        const val GET = "get"
    }
}