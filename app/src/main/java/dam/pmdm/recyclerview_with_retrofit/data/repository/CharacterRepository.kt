package dam.pmdm.recyclerview_with_retrofit.data.repository

import dam.pmdm.recyclerview_with_retrofit.data.model.Item
import dam.pmdm.recyclerview_with_retrofit.data.remote.RetrofitInstance

class CharacterRepository {
    suspend fun getCharacters(): List<Item> {
        return RetrofitInstance.api.getCharacters().results
    }
}