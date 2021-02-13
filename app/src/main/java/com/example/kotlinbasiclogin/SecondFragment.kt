package com.example.kotlinbasiclogin

import android.graphics.Color
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


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
        val rvcontacts = view.findViewById<RecyclerView>(R.id.contactsRViewer) as RecyclerView


        rvcontacts.layoutManager = LinearLayoutManager(context)

        //Assign the adapter for rvcontacts and make it use the List of contacts retrieved by parseJson
        rvcontacts.adapter = parseJSON()?.let { ContactsAdapter(it) }
        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        //Test function
        println(parseJSON().toString());

    }
        //deprecated function used in testing
       fun createList(): List<ContactData> {
           var con1 = parseJSON()!!.get(0)

           var listee = listOf<ContactData>(con1)
           return listee
       }






}


