package com.coded.spring.ordering.profile

import com.coded.spring.ordering.user.UsersRepository
import jakarta.transaction.Transactional
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
open class ProfileService(
    private val profileRepository: ProfileRepository,
    private val usersRepository: UsersRepository
) {

    fun isValidName(name: String): Boolean {
        val pattern = "[A-Za-z]{1,}".toRegex()  // Checks if a name contains only letters (A-Z or a-z) + at least 1 letter
        return pattern.matches(name) // Returns true if name matches the pattern
    }


    // Checks if the phone number is exactly 8 digits long
    fun isValidPhone(phone: String): Boolean {
        val digitsOnly = Regex("\\d{8}")
        return digitsOnly.matches(phone) //  true if phone matches the pattern
    }

    @Transactional
    fun saveProfile(username: String, request: ProfileRequest): ProfileEntity {
        val user = usersRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("User not found")


        // Check if the user already has a profile
        val existingProfile = profileRepository.findByUserId(user.id!!)
        if (existingProfile != null) {
            throw IllegalArgumentException("Profile already exists for this user")
        }


        // Check if first name is valid (only letters)
        if (!isValidName(request.firstName)) {
            throw IllegalArgumentException("First name must contain only letters")
        }

        // Check if last name is valid (only letters)
        if (!isValidName(request.lastName)) {
            throw IllegalArgumentException("Last name must contain only letters")
        }

        // Check if phone number is valid (8 digits)
        if (!isValidPhone(request.phoneNumber)) {
            throw IllegalArgumentException("Phone number must be exactly 8 digits")
        }


        // Create a new profile with the given data
        val profile = ProfileEntity(
            firstName = request.firstName,
            lastName = request.lastName,
            phoneNumber = request.phoneNumber,
            userId = user.id!!
        )

        return profileRepository.save(profile)   // Save the new profile in the DB and return it
    }


    // Get the profile for a user using their username
    fun getByUsername(username: String): ProfileEntity {
        val user = usersRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("User not found")


        // Get the profile for the user's ID
        val profile = profileRepository.findByUserId(user.id!!)
            ?: throw IllegalArgumentException("Profile not found for this user")

        return profile
    }
}
