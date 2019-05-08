package ninja.saad.moviemashup.util

import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView
import ninja.saad.moviemashup.util.Constant


@BindingAdapter("bind:imgName", "bind:imgSize")
fun bindImageUrl(simpleDraweeView: SimpleDraweeView, imgName: String, imgSize: String) {
    val imgUrl = "${Constant.IMG_BASE_URL}${imgSize}${imgName}"
    simpleDraweeView.setImageURI(imgUrl)
}

@BindingAdapter("bind:visible")
fun bindVisible(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}