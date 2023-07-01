package com.example.minor

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.minor.databinding.ContactLayoutBinding

class ContactAdapter(val context: Context, val list: List<Contacts>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    class ViewHolder(val binding: ContactLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

    private val dao = ContactDatabase.getDatabaseInstance(context).contactDao()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ContactLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvContactName.text = list[position].name
        holder.binding.tvContactNumber.text = list[position].number
        holder.binding.btnDeleteContact.setOnClickListener {
            dao.delete(list[position])
            notifyItemRemoved(position)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("" + list[position].number))
            context.startActivity(intent)
        }
    }

}