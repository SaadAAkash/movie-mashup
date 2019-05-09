package ninja.saad.moviemashup.core

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    abstract fun dispose()
}