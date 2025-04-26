package com.coded.spring.ordering.order

import com.coded.spring.ordering.item.Item
import com.coded.spring.ordering.item.ItemsRepository
import com.coded.spring.ordering.user.UsersRepository
import jakarta.inject.Named

@Named
class OrdersService(
    private val ordersRepository: OrdersRepository,
    private val usersRepository: UsersRepository,
    private val itemsRepository: ItemsRepository
) {

    fun submitOrder(username: String, itemIds: List<Long>) {
        val user = usersRepository.findByUsername(username)
            ?: throw IllegalArgumentException("User not found") // If the user doesn't exist, throw an exception


        val order = OrderEntity(user = user)  // Create a new order for the user
        val savedOrder = ordersRepository.save(order)


        // Get all items from the database using the provided item IDs
        val items = itemsRepository.findAllById(itemIds).map { item ->
            // Assign the newly created order to each item
            item.order = savedOrder
            item
        }

        itemsRepository.saveAll(items)
    }


    //get all orders for a specific user
    fun listOrdersForUser(username: String): List<Order> {
        val user = usersRepository.findByUsername(username)
            ?: throw IllegalArgumentException("User not found")

        // Get all orders that belong to the user based on their user ID
        return ordersRepository.findByUserId(user.id!!).map { orderEntity ->
            Order(id = orderEntity.id, user_id = user.id, items = orderEntity.items?.map {
                    Item(id = it.id, order_id = it.order?.id, name = it.name, quantity = it.quantity, note = it.note, price = it.price)
                } ?: listOf() // If there are no items, return an empty list
            )
        }
    }
}
