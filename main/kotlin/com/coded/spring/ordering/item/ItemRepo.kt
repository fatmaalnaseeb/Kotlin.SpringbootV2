package com.coded.spring.ordering.item

import org.springframework.data.jpa.repository.JpaRepository

interface ItemsRepository : JpaRepository<ItemEntity, Long>