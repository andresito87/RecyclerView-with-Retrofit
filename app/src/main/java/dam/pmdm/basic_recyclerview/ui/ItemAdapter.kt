package dam.pmdm.basic_recyclerview.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import dam.pmdm.basic_recyclerview.R
import dam.pmdm.basic_recyclerview.data.model.Item
import dam.pmdm.basic_recyclerview.databinding.ItemCardviewBinding

class ItemAdapter(
    private val items: List<Item>,
    private val onItemClicked: (Item) -> Unit
) : RecyclerView.Adapter<ItemViewHolder>() {

    // Método que crea el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ItemCardviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    // Método que enlaza datos al ViewHolder
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]

        holder.bind(currentItem)

        // Manejar el evento de clic
        holder.itemView.setOnClickListener {
            onItemClicked(currentItem)
        }
    }

    override fun getItemCount(): Int = items.size

}

class ItemViewHolder(private val binding: ItemCardviewBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Item) {
        binding.image.load(item.image) {
            placeholder(R.drawable.error) // Imagen mientras se carga
            error(R.drawable.error)  // Imagen si falla la carga
        }
        binding.name.text = item.name
    }
}