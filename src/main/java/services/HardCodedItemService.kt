package services

import services.dto.ItemDTO
import services.exceptions.IdAlreadyInUseException
import services.exceptions.ItemNotAvailableException
import java.util.stream.Collectors
import javax.enterprise.inject.Default

@Default
class HardCodedItemService : ItemService {
    private var items = mutableListOf<ItemDTO>()

    init {
        items.add(ItemDTO(1, "Bread", arrayOf("Breakfast, Lunch"), "Delicious!"))
        items.add(ItemDTO(2, "Butter", arrayOf("Breakfast, Lunch"), "Use it with bread"))
        items.add(ItemDTO(3, "Honey", arrayOf("Breakfast, Lunch"), "Use it with bread"))
    }

    override fun getAll(): Collection<ItemDTO> {
        return items
    }

    override fun addItem(itemDTO: ItemDTO) {
        if (items.stream().anyMatch { item -> item.id == itemDTO.id }) throw IdAlreadyInUseException("Id is already is use")
        items.add(itemDTO)
    }

    override fun getItem(id: Int): ItemDTO {
        val requestedItem = items.stream().filter { item -> item.id == id }.findFirst()
        return if (requestedItem.isPresent) {
            requestedItem.get()
        } else {
            throw ItemNotAvailableException("Item is not available")
        }
    }

    override fun deleteItem(id: Int) {
        val itemForName = items.stream().filter { item -> item.id == id }.findFirst()
        val filteredItems = items.stream().filter { item -> item.id != id }.collect(Collectors.toList())

        if (filteredItems.size == items.size) {
            throw ItemNotAvailableException("Item not available")
        }

        items = filteredItems
    }
}