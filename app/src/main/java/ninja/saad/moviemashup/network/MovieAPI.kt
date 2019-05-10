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
}