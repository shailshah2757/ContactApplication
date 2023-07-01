package com.example.minor

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact: Contacts)

    @Query("Select * from Contacts")
    fun getAllContacts() : LiveData<List<Contacts>>

    @Delete
    fun delete(contact: Contacts)

}