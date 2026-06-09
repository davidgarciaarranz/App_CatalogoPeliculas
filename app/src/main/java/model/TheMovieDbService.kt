package model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDbService {

    @GET("movie/popular")
    fun listPopularMovies(
        @Query("api_key") api_key: String,
        @Query("language") language: String = "es-ES",
        @Query("page") page: Int = 1
    ) : Call<MovieBdResult>
}