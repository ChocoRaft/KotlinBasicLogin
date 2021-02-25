package com.fyntros.android

import com.google.gson.annotations.SerializedName


//Data class to contain the Data for the Users from the Nested Contact JSON object
data class ContactData(
                //rr
        @SerializedName("id")
        var employeeId: String?,

        @SerializedName("name")
        var employeeName: String?,

        @SerializedName("email")
        var email: String?,

        @SerializedName("gender")
        var gender: String?,

        @SerializedName("status")
        var status: String?,

        @SerializedName("created_at")
        var created_at: String?,

        @SerializedName("updated_at")
        var updated_at: String?

)