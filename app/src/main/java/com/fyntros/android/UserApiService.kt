package com.fyntros.android


import kotlinx.coroutines.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//BASE URL sets the url to get data from
const val BASE_URL =
    "https://gorest.co.in/public-api/users/"


//Interface to get the "users" data in a Contact JSON object form
interface UserApiService {
    @GET("users")
    suspend fun getEmployees(): Response<Contact>

}

//Function to parse the Contact JSON object and return a List of ContactData objects that contain individual users

@Suppress("UNCHECKED_CAST")
fun  parseJSON(): List<ContactData>? = runBlocking {
    val contactlist: List<ContactData>?
    // Create Retrofit
    val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    // Create Service
    val service = retrofit.create(UserApiService::class.java)

        // Do the GET request and get response
        val response = service.getEmployees()
        //Assign the "data" from the body of the response to the list of contacts
        contactlist = response.body()!!.data
        //test function to see if contactlist is getting something or not
        println(contactlist)


    //return contactlist. runBlocking is used so that the views do not load until the data has been retrieved.
    return@runBlocking contactlist
}


