package com.coded.spring.ordering.user

import jakarta.inject.Named
@Named
class UsersService(
    private val usersRepository: UsersRepository,
) {

    fun listUsers(): List<User> = usersRepository.findAll().map {
        User(name = it.name, age = it.age, username = it.username, password = it.password) // Create a new User using the data from the database
    }
}

