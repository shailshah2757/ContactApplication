package com.example.minor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.minor.databinding.ActivityContactBinding

class ContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactBinding

    val ViewModel: ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContactBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            createContact(it)
        }
    }

    private fun createContact(it: View) {
        val name = binding.etContactName.text.toString()
        val number = binding.etContactNumber.text.toString()

        val data = Contacts(null, name = name, number = number)

        ViewModel.addContacts(data)

        Toast.makeText(this@ContactActivity, "Saved", Toast.LENGTH_SHORT).show()

        startActivity(Intent(this@ContactActivity, MainActivity::class.java))
    }
}