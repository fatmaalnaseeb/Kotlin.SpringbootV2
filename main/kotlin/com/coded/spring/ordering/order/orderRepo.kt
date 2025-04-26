package com.coded.spring.ordering.order


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrdersRepository: JpaRepository<OrderEntity, Long>{
    fun findByUserId(userId: Long): List<OrderEntity>
}