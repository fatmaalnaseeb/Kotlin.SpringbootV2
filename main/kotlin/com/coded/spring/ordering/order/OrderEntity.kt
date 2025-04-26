package com.coded.spring.ordering.order

import com.coded.spring.ordering.item.ItemEntity
import com.coded.spring.ordering.user.UserEntity
import jakarta.persistence.*


@Entity
@Table(name = "orders")
class OrderEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: UserEntity? = null,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    var items: List<ItemEntity>? = null

) {
    constructor() : this(null, null, listOf())
}