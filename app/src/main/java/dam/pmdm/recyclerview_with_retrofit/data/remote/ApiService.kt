package dam.pmdm.recyclerview_with_retrofit.data.remote

import dam.pmdm.recyclerview_with_retrofit.data.model.ItemResponse
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun getCharacters(): ItemResponse
}