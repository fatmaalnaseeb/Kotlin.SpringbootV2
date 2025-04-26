package com.coded.spring.ordering.item

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController


class ItemsController(private val itemsService: ItemsServ) {


    @GetMapping("/listItems")
    fun listItems(): List<Item> = itemsService.listItems()



    @PostMapping("/submitItems")
    fun submitItem(@RequestBody request: SubmitItemRequest): ItemEntity {
        return itemsService.submitItem(request)
    }

}