package ninja.saad.moviemashup.features.dashboard

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import ninja.saad.moviemashup.R
import ninja.saad.moviemashup.core.BaseViewModel
import ninja.saad.moviemashup.data.MovieRepository
import ninja.saad.moviemashup.data.model.Movie
import ninja.saad.moviemashup.data.model.MovieResponse
import ninja.saad.moviemashup.util.Toaster
import java.util.*
import javax.inject.Inject

class PageViewModel @Inject constructor(val repository: MovieRepository): BaseViewModel() {

    val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Hello world from section: $it"
    }

    val movies = ObservableArrayList<Movie>()
    val showError = ObservableField<Boolean>(false)
    val showLoading = ObservableField<Boolean>(false)
    var date: Date? = null
    private var page: Int = 1
    private var subscription: Disposable? = null
    private var totalPages = -1

    fun setIndex(index: Int) {
        _index.value = index
    }

    // Returns if request was accepted
    fun loadMovies(selectedDate: Date? = date){
        if (date != selectedDate) {
            // Requested with new date, so start from page 1
            page = 1
            totalPages = -1
            movies.clear()
            subscription?.dispose()
            showLoading.set(false)
            this.date = selectedDate
        }
        if (showLoading.get()!! || totalPages == page) {
            return
        }
        showLoading.set(true)
        showError.set(false)
        subscription = repository.getMovies(page, date!!).subscribe({
                response: MovieResponse ->
            response.results?.let {
                movies.addAll(response.results)
                page = response.page!! + 1
                totalPages = response.totalPages!!
            }

        },handleError,{
            showLoading.set(false)
        })
    }

    var handleError = fun (t: Throwable) {
        t.printStackTrace()
        showLoading.set(false)
        if (movies.size == 0) {
            showError.set(true)
        } else {
            //toaster.showLong(R.string.msg_unable_to_load)
        }
    }

    override fun dispose() {
        subscription?.dispose()
        showLoading.set(false)
        showError.set(false)
    }
}