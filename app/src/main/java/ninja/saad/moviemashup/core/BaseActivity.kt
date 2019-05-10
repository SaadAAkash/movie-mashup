package ninja.saad.moviemashup.core


import android.app.ProgressDialog
import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

open class BaseActivity : AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog
    lateinit var builder: AlertDialog.Builder
    lateinit var currentAlertDialog: AlertDialog

    val isOnline: Boolean
        get() {
            val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            return netInfo != null && netInfo.isConnectedOrConnecting
        }

    override fun getBaseContext(): Context {
        return applicationContext
    }

    fun showLongToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    fun showProgressDialog(context: Context, title: String, message: String) {
        progressDialog = ProgressDialog(context)
        progressDialog.max = 100
        progressDialog.setTitle(title)
        progressDialog.setMessage(message)
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        progressDialog.show()
        progressDialog.setCancelable(false)
    }

    fun dismissProgressDialogue(context: Context) {
        progressDialog.dismiss()
    }

    fun showAlertDialog(context: Context, title: String, message: String) {
        builder = AlertDialog.Builder(context)

        builder.setTitle(title)
        builder.setCancelable(false)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialogInterface, i ->
            //((Activity)context).finish();
        }
        builder.setNegativeButton("Cancel") { dialogInterface, i ->
            //((Activity)context).finish();
        }

        currentAlertDialog = builder.create()
        currentAlertDialog.show()
    }

    fun dismissAlertDialog(context: Context) {
        if (currentAlertDialog.isShowing)
            currentAlertDialog.dismiss()
    }

    fun showShortToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    fun myCurrentDateFormat(): String {
        val dateFormat = SimpleDateFormat("yyyyMMdd_HHmmss")
        return dateFormat.format(Date())
    }

}
