package ninja.saad.moviemashup.data

import io.reactivex.Observable
import ninja.saad.moviemashup.data.model.MovieResponse
import java.util.*

interface MovieRepository {

    fun getMovies(page: Int, date: Date): Observable<MovieResponse>

}