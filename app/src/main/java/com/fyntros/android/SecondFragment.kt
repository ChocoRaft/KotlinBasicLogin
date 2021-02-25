package com.fyntros.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * A second Fragment that would show the users and their data
 */
class SecondFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //Rvcontacts is the designation for the recyclerview container itself
        val rvcontacts = view.findViewById(R.id.contactsRViewer) as RecyclerView


        rvcontacts.layoutManager = LinearLayoutManager(context)

        //Assign the adapter for rvcontacts and make it use the List of contacts retrieved by parseJson
        rvcontacts.adapter = parseJSON()?.let { ContactsAdapter(it) }
        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        //Test function
        println(parseJSON().toString())

    }







}


