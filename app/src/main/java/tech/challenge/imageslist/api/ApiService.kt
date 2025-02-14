package tech.challenge.imageslist.api

import retrofit2.http.GET
import retrofit2.http.Query
import tech.challenge.imageslist.models.Photo

interface ApiService {
    @GET("photos")
    suspend fun getPhotos(
        @Query("_page") page: Int,
        @Query("_limit") limit: Int
    ): List<Photo>
}