package com.coded.spring.ordering

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class userco (val UserRepository : UserRepository) {
    @GetMapping("/users2")
    fun getall(): List<ue>{
        return UserRepository.findAll()
    }

}

