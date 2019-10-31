package services

import services.dto.ItemDTO

interface ItemService {
    fun getAll() : Collection<ItemDTO>?
    fun addItem(itemDTO: ItemDTO)
    fun getItem(id: Int) : ItemDTO?
    fun deleteItem(id: Int)
}