package com.coded.spring.ordering.menu

//import org.springframework.stereotype.Service
import jakarta.inject.Named
@Named
//@Service
class MenuServ(private val menuRepository: MenuRepository) {
    fun getMenu(): List<MenuEntity> = menuRepository.findAll()
}