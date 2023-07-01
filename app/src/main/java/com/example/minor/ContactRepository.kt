package com.example.minor

import androidx.lifecycle.LiveData

class ContactRepository (val dao: ContactDao) {
    fun getAllContacts() : LiveData<List<Contacts>> {
        return dao.getAllContacts()
    }

    fun insertContact(contact: Contacts) {
        dao.insertContact(contact)
    }

    fun deleteContact(contact: Contacts) {
        dao.delete(contact)
    }
}