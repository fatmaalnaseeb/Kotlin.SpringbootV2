package com.coded.spring.ordering

data class OrderDTO (
    val user: String,
    val resturant: String,
    val items: List<String>
    )