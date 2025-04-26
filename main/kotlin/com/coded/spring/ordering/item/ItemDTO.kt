package com.coded.spring.ordering.item

data class Item(
    val id: Long?,
    val order_id: Long?,
    val name: String?,
    val quantity: Long?,
    val note: String?,
    val price: Double?
)

data class SubmitItemRequest(
    val name: String,
    val quantity: Long,
    val note: String?,
    val price: Double
)