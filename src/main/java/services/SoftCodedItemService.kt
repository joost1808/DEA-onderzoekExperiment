package services

import services.dto.ItemDTO
import javax.enterprise.inject.Alternative

@Alternative
class SoftCodedItemService : ItemService {
    override fun getAll(): Collection<ItemDTO>? {
        return null
    }

    override fun addItem(itemDTO: ItemDTO) {
    }

    override fun getItem(id: Int): ItemDTO? {
        return null
    }

    override fun deleteItem(id: Int) {
    }
}