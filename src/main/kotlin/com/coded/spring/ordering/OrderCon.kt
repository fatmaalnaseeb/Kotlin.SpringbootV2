package com.coded.spring.ordering

import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/orders")
class OrderCon (val orderRepository: OrderRepository){


    @PostMapping
    fun createOrder(@RequestBody orderDTO: OrderDTO): String {
        val order = Order(
            user = orderDTO.user,
            resturant = orderDTO.resturant,
            items = orderDTO.items
        )
        orderRepository.save(order)
        return "Order submitted successfully"
    }

    @GetMapping
    fun listOrders(): List<Order> {
        return orderRepository.findAll()

    }


}