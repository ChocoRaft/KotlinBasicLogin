package com.fyntros.android


import com.google.gson.annotations.SerializedName

//Data class that gets the Nested JSON object of the users
data class Contact(
        @SerializedName("data")
        var data: List<ContactData>
)

