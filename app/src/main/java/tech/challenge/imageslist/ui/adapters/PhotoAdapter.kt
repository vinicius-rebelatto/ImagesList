package tech.challenge.imageslist.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tech.challenge.imageslist.R
import tech.challenge.imageslist.models.Photo

class PhotoAdapter(
    private val photos: MutableList<Photo>,
    private val loadMore: () -> Unit // Callback to load more data
) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo)

        // Load more data when the user reaches the end of the list
        if (position == photos.size - 1) {
            loadMore()
        }
    }

    override fun getItemCount(): Int = photos.size

    // Add new photos to the list
    fun addPhotos(newPhotos: List<Photo>) {
        val oldSize = photos.size
        photos.addAll(newPhotos)
        notifyItemRangeInserted(oldSize, newPhotos.size)
    }

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val thumbnailImageView: ImageView = itemView.findViewById(R.id.thumbnailImageView)

        fun bind(photo: Photo) {
            titleTextView.text = photo.title

            // Generate a random image URL using the photo's title as a seed
            val randomImageUrl = "https://picsum.photos/200/300?random=${photo.title.hashCode()}"

            // Load the random image using Glide
            Glide.with(itemView.context)
                .load(randomImageUrl)
                .into(thumbnailImageView)
        }
    }
}