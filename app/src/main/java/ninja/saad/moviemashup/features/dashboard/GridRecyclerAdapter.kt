package ninja.saad.moviemashup.features.dashboard

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ninja.saad.moviemashup.R

class GridRecyclerAdapter(private val mClickHandler: RecyclerAdapterOnClickHandler, private val data: List<String>) : RecyclerView.Adapter<GridRecyclerAdapter.GridRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridRecyclerViewHolder {
        val context = parent.context
        val layoutIdForListItem = R.layout.item_dashboard_rv
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(layoutIdForListItem, parent, false)
        return GridRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridRecyclerViewHolder, position: Int) {
        val context = holder.mainImageView.context
        val info = data[position]
        var id = context.resources.getIdentifier(info.toLowerCase(), "drawable", context.packageName)
        when (position) {
            0 -> id = context.resources.getIdentifier("ic_discover", "drawable", context.packageName)
            1 -> id = context.resources.getIdentifier("ic_popular", "drawable", context.packageName)
            2 -> id = context.resources.getIdentifier("ic_upcoming", "drawable", context.packageName)
            3 -> id = context.resources.getIdentifier("ic_trending", "drawable", context.packageName)
            4 -> id = context.resources.getIdentifier("ic_now_playing", "drawable", context.packageName)
            5 -> id = context.resources.getIdentifier("ic_top_rated", "drawable", context.packageName)
        }
        holder.mainImageView.setImageResource(id)
        holder.name.text = info
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface RecyclerAdapterOnClickHandler {
        fun onClick(target: String)
    }

    inner class GridRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var mainImageView: ImageView
        var name: TextView

        init {
            mainImageView = itemView.findViewById(R.id.rv_component_image)
            name = itemView.findViewById(R.id.rv_component_text)
            val custom_font = Typeface.createFromAsset(itemView.context.assets, "fonts/TitilliumWeb-SemiBold.ttf")
            name.typeface = custom_font
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val adapterPosition = adapterPosition
            val info = data[adapterPosition]
            mClickHandler.onClick(info)
        }
    }
}
