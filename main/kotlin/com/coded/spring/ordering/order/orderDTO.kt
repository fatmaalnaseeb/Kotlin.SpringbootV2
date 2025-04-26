package com.coded.spring.ordering.order

import com.coded.spring.ordering.item.Item
data class SubmitOrderRequest(
    val itemIds: List<Long>
)

data class Order(
   val id: Long?,
    val user_id: Long?,
    val items: List<Item>
)

//testing
data class CreateOrderResponse(
    val orderId: Long,
    val items: List<Item> )

data class CreateOrderRequest(
    val userId: Long,
    val items: List<Item>
)