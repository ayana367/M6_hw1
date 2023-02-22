package com.example.m6_hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.m6_hw1.databinding.ActivityRecipientBinding

class RecipientActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipientBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListener()
    }

    private fun initListener() {
        binding.edtTitle.setText(intent.getStringExtra(MainActivity.HAND_OVER))

        binding.btnGet.setOnClickListener {
            if (binding.edtTitle.text.isEmpty()) {
                Toast.makeText(
                    this,
                    getString(R.string.the_text_is_empty_enter_the_text),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val i = intent.putExtra(MainActivity.GET, binding.edtTitle.text.toString())
                setResult(RESULT_OK, i)
                finish()
            }
        }
    }
}