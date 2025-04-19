package com.coded.spring.ordering

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<ue, Int>



@Entity
@Table(name = "users2")
data class ue (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int,

    var name: String,
    var age: Int?,
){
    constructor() : this(0, "", null)
}