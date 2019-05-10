package ninja.saad.moviemashup.network

import io.reactivex.Observable
import ninja.saad.moviemashup.data.model.MovieResponse
import ninja.saad.moviemashup.util.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    @GET("/3/discover/movie")
    fun discover(
        @Query("release_date.gte") date: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = Constant.API_KEY
    ): Observable<MovieResponse>

    @GET("/3/trending/movie/day")
    fun trending(
        @Query("media_type") mediaType: String,
        @Query("time_window") timeWindow: String,
        @Query("api_key") apiKey: String = Constant.API_KEY
    ): Observable<MovieResponse>

    @GET("/3/discover/movie")
    fun sortedlist(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = Constant.API_KEY,
        @Query("sort_by") sortBy: String,
        @Query("vote_count.gte") minVoteCount: Number
    ): Observable<MovieResponse>

    @GET("/3/discover/movie")
    fun newarrival(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = Constant.API_KEY,
        @Query("year") year: Int
    ): Observable<MovieResponse>


}