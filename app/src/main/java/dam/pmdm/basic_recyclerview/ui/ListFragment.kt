package dam.pmdm.basic_recyclerview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dam.pmdm.basic_recyclerview.data.model.Item
import dam.pmdm.basic_recyclerview.databinding.FragmentListBinding

class ListFragment: Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var myAdapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

//        Llenar lista con datos
        loadItems()

        return binding.root
    }

    private fun onGameClicked(itemData: Item) {
        // Do anything
    }

    // Metodo para cargar juegos
    private fun loadItems() {
        val itemList = listOf(
            Item("https://cdn.iconscout.com/icon/free/png-256/free-avatar-icon-svg-download-png-456327.png", "Paco"),
            Item("https://images.icon-icons.com/2643/PNG/512/avatar_female_woman_person_people_white_tone_icon_159360.png", "Ana"),
            Item("https://cdn-icons-png.freepik.com/512/6858/6858478.png", "Maria")
        )
        setupRecyclerView(itemList)
    }

    private fun setupRecyclerView(itemList: List<Item>) {
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        myAdapter = ItemAdapter(itemList, ::onGameClicked)
        binding.recyclerview.adapter = myAdapter
    }
}