package com.coded.spring.ordering

import com.coded.spring.ordering.user.UserEntity
import com.coded.spring.ordering.user.UsersRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

//@SpringBootApplication
//@Component
//class InitUserRunner {
//    @Bean
//    fun initUsers(userRepository: UsersRepository, passwordEncoder: PasswordEncoder) = CommandLineRunner {
//        val user = UserEntity(
//            id =null,
//            name ="Fatma",
//            age = 23,
//            username = "FFN",
//            password = passwordEncoder.encode("123"),
//
//        )
//        if (userRepository.findByUsername(user.username) == null) {
//            println("Creating user ${user.username}")
//            userRepository.save(user)
//        } else  {
//            println("User ${user.username} already exists")
//        }
//    }
//}

//fun main(args: Array<String>) {
 //   runApplication<InitUserRunner>(*args).close()
//}