package ninja.saad.moviemashup.features.dashboard

import android.content.Context
import ninja.saad.moviemashup.R
import java.util.*

object DashboardFeatureList {

    fun getFeatureListOfDashboard(mContext: Context): List<String> {
        val list = ArrayList<String>()
        list.add(mContext.resources.getString(R.string.feature01))
        list.add(mContext.resources.getString(R.string.feature02))
        list.add(mContext.resources.getString(R.string.feature03))
        list.add(mContext.resources.getString(R.string.feature04))
        list.add(mContext.resources.getString(R.string.feature05))
        list.add(mContext.resources.getString(R.string.feature06))
        return list
    }

}