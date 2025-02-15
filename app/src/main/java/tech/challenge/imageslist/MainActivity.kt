package tech.challenge.imageslist

    import android.os.Bundle
import android.util.Log
    import androidx.activity.viewModels
    import androidx.appcompat.app.AppCompatActivity
    import androidx.lifecycle.Observer
    import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import tech.challenge.imageslist.api.RetrofitClient
    import tech.challenge.imageslist.models.Photo
    import tech.challenge.imageslist.ui.adapters.PhotoAdapter
    import tech.challenge.imageslist.viewmodels.PhotoViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PhotoAdapter
    private val viewModel: PhotoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the adapter
        adapter = PhotoAdapter(mutableListOf()) { viewModel.loadMorePhotos() }
        recyclerView.adapter = adapter

        // Observe the photos LiveData
        viewModel.photos.observe(this, Observer { newPhotos ->
            adapter.addPhotos(newPhotos)
        })

        // Load the first page of data
        viewModel.loadMorePhotos()
    }
}