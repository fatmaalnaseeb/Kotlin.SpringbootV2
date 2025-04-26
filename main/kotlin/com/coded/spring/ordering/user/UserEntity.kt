package com.coded.spring.ordering.user

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long ?= null,
    var name: String,
    var age : Int,
    var username: String,
    var password: String,

    //@Enumerated(EnumType.STRING)
    //val role: Roles = Roles.USER
) {
    constructor() : this(null,"",  0, "","" )
}

//enum class Roles {
  //  USER, ADMIN
//}