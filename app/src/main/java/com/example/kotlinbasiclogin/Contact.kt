package com.example.kotlinbasiclogin


import com.google.gson.annotations.SerializedName
import kotlin.collections.ArrayList

//Data class that gets the Nested JSON object of the users
data class Contact(
        @SerializedName("data")
        var data: List<ContactData>
)

