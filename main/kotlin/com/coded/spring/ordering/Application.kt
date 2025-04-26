package com.coded.spring.ordering

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication
//@EntityScan("com.coded.spring.ordering")  // <- your package
//@EnableJpaRepositories(basePackages = ["com.coded.spring.ordering"])


class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
