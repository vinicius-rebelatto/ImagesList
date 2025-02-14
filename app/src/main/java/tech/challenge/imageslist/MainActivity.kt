package tech.challenge.imageslist

    import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import tech.challenge.imageslist.api.RetrofitClient
    import tech.challenge.imageslist.models.Photo
    import tech.challenge.imageslist.ui.adapters.PhotoAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PhotoAdapter
    private val photos = mutableListOf<Photo>()
    private var currentPage = 1
    private val limit = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Set the layout

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the adapter
        adapter = PhotoAdapter(photos) { loadMorePhotos() }
        recyclerView.adapter = adapter

        // Load the first page of data
        loadMorePhotos()
    }

    private fun loadMorePhotos() {
        lifecycleScope.launch {
            try {
                val newPhotos = RetrofitClient.apiService.getPhotos(currentPage, limit)
                if (newPhotos.isNotEmpty()) {
                    adapter.addPhotos(newPhotos)
                    currentPage++
                }
            } catch (e: Exception) {
                Log.e("MainActivity", "Error fetching photos", e)
            }
        }
    }
}