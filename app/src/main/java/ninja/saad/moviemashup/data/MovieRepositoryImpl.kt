package ninja.saad.moviemashup.data

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ninja.saad.moviemashup.data.model.MovieResponse
import ninja.saad.moviemashup.network.MovieAPI
import ninja.saad.moviemashup.util.toReleaseFormat
import java.util.*
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(var movieAPI: MovieAPI) : MovieRepository {

    override fun getMovies(page: Int, date: Date): Observable<MovieResponse> {
        return movieAPI.discover(page = page, date = date.toReleaseFormat())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getTrending(mediaType: String, timeWindow: String): Observable<MovieResponse> {
        return movieAPI.trending(mediaType = "movie", timeWindow = "day")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}