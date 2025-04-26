package com.coded.spring.ordering.profile

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal


@RestController
@RequestMapping("/profile")
class ProfileController(
    private val profileService: ProfileService
) {

    @PostMapping
    fun submitProfile(
        @RequestBody request: ProfileRequest,
        principal: Principal
    ): ResponseEntity<Any> {
        return try {
            // Call the profile service to save the profile for the authenticated user
            profileService.saveProfile(principal.name, request)
            ResponseEntity.ok(mapOf("message" to "Profile created successfully."))
        } catch (e: IllegalArgumentException) {
            // Handle validation errors
            ResponseEntity.badRequest().body(mapOf("error" to e.message))
        } catch (e: Exception) {
            // Handle other unexpected errors
            e.printStackTrace()
            ResponseEntity.internalServerError().body(mapOf("error" to "Something went wrong."))
        }
    }

    @GetMapping
    fun getProfile(principal: Principal): ResponseEntity<Any> {
        return try {
            // Fetch and return the profile of the authenticated user
            val profile = profileService.getByUsername(principal.name)
            ResponseEntity.ok(profile)
        } catch (e: IllegalArgumentException) {
            // Handle case when profile is not found
            ResponseEntity.badRequest().body(mapOf("error" to e.message))
        } catch (e: Exception) {
            // Handle other unexpected errors
            e.printStackTrace()
            ResponseEntity.internalServerError().body(mapOf("error" to "Something went wrong"))
        }
    }
}