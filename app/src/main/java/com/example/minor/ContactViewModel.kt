package com.example.minor

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ContactViewModel(application: Application) : AndroidViewModel(application) {
    val repository: ContactRepository

    init {
        val dao = ContactDatabase.getDatabaseInstance(application).contactDao()
        repository = ContactRepository(dao)
    }

    fun addContacts(contact: Contacts) {
        repository.insertContact(contact)
    }

    fun getAllContacts(): LiveData<List<Contacts>> = repository.getAllContacts()
}