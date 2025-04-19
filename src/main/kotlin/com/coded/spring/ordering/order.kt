package com.coded.spring.ordering

import jakarta.persistence.*


@Entity
@Table(name = "orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "user_id")
    val user: String,

    val resturant: String,

    @ElementCollection
    val items: List<String>
) {
    constructor() : this(0, "", "", listOf())
}