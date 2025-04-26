package com.coded.spring.ordering.order


//import org.hibernate.query.Order
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/orders/v1")
class OrderController(val ordersRepository: OrdersRepository, private val ordersService: OrdersService){

    @PostMapping
    fun submitOrder(
        // Extracts the logged-in user's details
        @RequestBody request: SubmitOrderRequest, principal: Principal): ResponseEntity<String> {

        val username = principal.name // Fetch the logged-in user's username

        ordersService.submitOrder(username, request.itemIds)

        return ResponseEntity.ok(" submitted.")
    }

    @GetMapping
    //list all orders for the logged-in user
    fun listMyOrders(principal: Principal): List<Order> {
        return ordersService.listOrdersForUser(principal.name) // Call the service to get all orders for the logged-in user

    }


}
