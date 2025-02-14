package tech.challenge.imageslist

    import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import tech.challenge.imageslist.api.RetrofitClient
import tech.challenge.imageslist.ui.adapters.PhotoAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Set the layout

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch data from the API
        fetchPhotos()
    }

    private fun fetchPhotos() {
        lifecycleScope.launch {
            try {
                val photos = RetrofitClient.apiService.getPhotos()
                adapter = PhotoAdapter(photos)
                recyclerView.adapter = adapter
            } catch (e: Exception) {
                Log.e("MainActivity", "Error fetching photos", e)
            }
        }
    }
}