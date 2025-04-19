package com.coded.spring.ordering

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController

class WelcomeToOnlineOrdering {

    @GetMapping("/")
    fun welcome(): String{
        return "Your Order Await"
    }

}