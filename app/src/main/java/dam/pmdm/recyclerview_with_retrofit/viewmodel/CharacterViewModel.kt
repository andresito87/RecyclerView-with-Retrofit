package dam.pmdm.recyclerview_with_retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dam.pmdm.recyclerview_with_retrofit.data.model.Item
import dam.pmdm.recyclerview_with_retrofit.data.repository.CharacterRepository
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val repository = CharacterRepository()

    private val _characters = MutableLiveData<List<Item>>()
    val characters: LiveData<List<Item>> = _characters

    fun loadCharacters() {
        viewModelScope.launch {
            try {
                _characters.value = repository.getCharacters()
            } catch (e: Exception) {
                _characters.value = emptyList()
            }
        }
    }
}