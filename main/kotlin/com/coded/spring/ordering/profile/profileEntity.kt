package com.coded.spring.ordering.profile

import jakarta.persistence.*

@Entity
@Table(name = "profiles")
data class ProfileEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val userId: Long = 0

)