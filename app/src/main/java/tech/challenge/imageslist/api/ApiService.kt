package tech.challenge.imageslist.api

import retrofit2.http.GET
import tech.challenge.imageslist.models.Photo

interface ApiService {
    @GET("photos")
    suspend fun getPhotos(): List<Photo>
}