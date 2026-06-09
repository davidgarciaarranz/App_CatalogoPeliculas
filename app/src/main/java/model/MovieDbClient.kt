package model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory

//modo singleton, para solo instanciar una clase de esta cosa
object MovieDbClient {

    private val retrofit = Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val service = retrofit.create (TheMovieDbService::class.java)

}
