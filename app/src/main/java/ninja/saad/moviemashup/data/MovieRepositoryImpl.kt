package ninja.saad.moviemashup.data

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ninja.saad.moviemashup.data.model.MovieResponse
import ninja.saad.moviemashup.network.MovieAPI
import ninja.saad.moviemashup.util.toReleaseFormat
import java.util.*
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(var movieAPI: MovieAPI.MovieAPI) : MovieRepository {

    override fun getMovies(page: Int, date: Date): Observable<MovieResponse> {
        return movieAPI.discover(page = page, date = date.toReleaseFormat())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}