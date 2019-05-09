package ninja.saad.moviemashup.util

import android.content.Context
import android.widget.Toast

class ToastManager(val context: Context): Toaster {
    override fun showLong(msg: Int) {
        showLong(context.resources.getString(msg))
    }

    override fun showLong(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

}