package com.coded.spring.ordering.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class UsersController(
    private val usersService: UsersService
) {

    @GetMapping("/welcome")
    fun users() = usersService.listUsers()



}