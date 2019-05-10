package ninja.saad.moviemashup.data

import io.reactivex.Observable
import ninja.saad.moviemashup.data.model.MovieResponse
import java.util.*

interface MovieRepository {

    fun getMovies(page: Int, date: Date): Observable<MovieResponse>
    fun getTrending(mediaType: String, timeWindow: String): Observable<MovieResponse>
    fun getSorted(page: Int, date: Date, sortBy : String, minVoteCount : Number): Observable<MovieResponse>
    fun getNewArrival(page: Int, year : Int): Observable<MovieResponse>
}