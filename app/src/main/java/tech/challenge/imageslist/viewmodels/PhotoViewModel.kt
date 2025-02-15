package tech.challenge.imageslist.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tech.challenge.imageslist.api.RetrofitClient
import tech.challenge.imageslist.models.Photo

class PhotoViewModel : ViewModel() {
    private val _photos = MutableLiveData<MutableList<Photo>>(mutableListOf())
    val photos: LiveData<MutableList<Photo>> get() = _photos

    private var currentPage = 1
    private val limit = 10 // Number of items per page

    fun loadMorePhotos() {
        viewModelScope.launch {
            try {
                val newPhotos = RetrofitClient.apiService.getPhotos(currentPage, limit)
                if (newPhotos.isNotEmpty()) {
                    _photos.value?.addAll(newPhotos)
                    _photos.value = _photos.value // Notify observers
                    currentPage++
                }
            } catch (e: Exception) {
                // Handle error (e.g., show a toast or log the error)
            }
        }
    }
}