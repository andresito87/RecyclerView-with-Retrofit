package dam.pmdm.recyclerview_with_retrofit.data.model

data class Item(
    val image: String,
    val name: String
)

data class ItemResponse(
    var results: List<Item>
)