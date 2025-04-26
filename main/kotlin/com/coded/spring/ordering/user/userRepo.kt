package com.coded.spring.ordering.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository : JpaRepository<UserEntity, Long> {
    fun findByUsername(username: String): UserEntity?
}
