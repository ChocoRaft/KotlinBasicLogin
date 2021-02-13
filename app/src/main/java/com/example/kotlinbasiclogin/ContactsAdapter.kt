package com.example.kotlinbasiclogin

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable

//Adapter Class to set and view the data from the ContactData objects in the List Views contained int the RecyclerView
class ContactsAdapter (private val mContacts: List<ContactData>): RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    //RecyclerView has its own
    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        //Assign variables to XML objects
        val nameTextView = itemView.findViewById<TextView>(R.id.contact_name)
        val emailTextView = itemView.findViewById<TextView>(R.id.email_text)
        val avatarView = itemView.findViewById<ImageView>(R.id.avatarImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.recycler_view_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: ContactsAdapter.ViewHolder, position: Int) {
        // Get the data object based on position
        val contact: ContactData = mContacts.get(position)

        //Custom initializing of a drawable variable tex to the first letter of the employee name.
        //This will be used to create the "avatar" for the contact
        val tex = TextDrawable.builder().buildRound(contact.employeeName?.get(0)?.toString(), Color.RED);


        //val image would be added in case of images being used. Unfortunately no images were provided in the data.

        // Set item views based on the views and ContactData
        val textView1 = viewHolder.nameTextView
        val textView2 = viewHolder.emailTextView
        val avatarImg = viewHolder.avatarView
        textView1.setText(contact.employeeName)
        textView2.setText((contact.email))



        // Add IF function here that runs this if no image file is found (if img returns null)
        avatarImg.setImageDrawable(tex)
    }

    //Function that gets us the size of the variables in mContacts
    override fun getItemCount(): Int {
        return mContacts.size
    }


}