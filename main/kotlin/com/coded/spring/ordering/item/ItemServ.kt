package com.coded.spring.ordering.item

import jakarta.inject.Named

@Named
class ItemsServ(private val itemsRepository: ItemsRepository) {
    fun listItems(): List<Item> = itemsRepository.findAll().map { entity ->
        Item(id = entity.id, order_id = entity.order?.id, name = entity.name, quantity = entity.quantity, note = entity.note, price = entity.price)
    }

    fun submitItem(request: SubmitItemRequest): ItemEntity {
        val item = ItemEntity(name = request.name, quantity = request.quantity, note = request.note, price = request.price)
        return itemsRepository.save(item)
    }

}