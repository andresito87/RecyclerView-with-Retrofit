package dam.pmdm.recyclerview_with_retrofit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dam.pmdm.recyclerview_with_retrofit.data.model.Item
import dam.pmdm.recyclerview_with_retrofit.databinding.FragmentListBinding
import dam.pmdm.recyclerview_with_retrofit.viewmodel.CharacterViewModel

class ListFragment: Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var myAdapter: ItemAdapter
    private lateinit var viewModel: CharacterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
        viewModel.characters.observe(viewLifecycleOwner) { list ->
            myAdapter.submitList(list)
        }
        viewModel.loadCharacters()
    }

    private fun onGameClicked(itemData: Item) {
        // Do anything
    }

    private fun setupRecyclerView() {
        myAdapter = ItemAdapter(listOf(), ::onGameClicked)
        binding.recyclerview.adapter = myAdapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
    }
}