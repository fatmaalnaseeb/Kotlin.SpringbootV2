package com.coded.spring.ordering.profile

import org.springframework.data.jpa.repository.JpaRepository

interface ProfileRepository : JpaRepository<ProfileEntity, Long> {
    fun findByUserId(userId: Long): ProfileEntity?
}
