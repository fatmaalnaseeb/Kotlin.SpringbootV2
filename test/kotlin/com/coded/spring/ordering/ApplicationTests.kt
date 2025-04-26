package com.coded.spring.ordering




import com.coded.spring.ordering.auth.JwtService
import com.coded.spring.ordering.item.Item
import com.coded.spring.ordering.order.CreateOrderRequest
import com.coded.spring.ordering.order.CreateOrderResponse
import com.coded.spring.ordering.user.UserEntity
import com.coded.spring.ordering.user.UsersRepository
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.context.ActiveProfiles
//import java.net.http.HttpHeaders
import org.springframework.http.HttpHeaders

//import kotlin.test.junit5.JUnit5Asserter.assertEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.util.MultiValueMap


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ApplicationTests {
	@Autowired
	lateinit var restTemplate: TestRestTemplate

	companion object {
		@JvmStatic
		@BeforeAll
		fun setUp(
			@Autowired usersRepository: UsersRepository,
			@Autowired passwordEncoder: PasswordEncoder,
		) {
			usersRepository.deleteAll()
			val testUser = UserEntity(
				name = "coded",
				age = 23,
				username = "coded",
				password = passwordEncoder.encode("joincoded")
			)
			usersRepository.save(testUser)
			println(testUser.id)
		}
	}

	@Test
	fun testHelloWorld(@Autowired jwtService: JwtService) {
		val token = jwtService.generateToken("coded")

		val headers = HttpHeaders()
		headers.set("Authorization", "Bearer $token")

		//val headers = HttpHeaders(
			//MultiValueMap.fromSingleValueMap(mapOf("Authorization" to "Bearer $token"))
		//)

		val requestEntity = HttpEntity<String>(headers)

		val result = restTemplate.exchange(
			"/hello",
			HttpMethod.GET,
			requestEntity,
			String::class.java
		)
		assertEquals(HttpStatus.OK, result.statusCode)
		assertEquals("Your Order Await", result.body)
	}

	@Test
	fun testOrderSubmit(@Autowired jwtService: JwtService) {
		val token = jwtService.generateToken("coded")

//		val headers = HttpHeaders()
//		headers.set("Authorization", "Bearer $token")

		val headers = HttpHeaders(
			MultiValueMap.fromSingleValue(mapOf("Authorization" to "Bearer $token"))
		)

		val body = CreateOrderRequest(
			userId = 15,
			items = listOf(
				Item(
					id = null,
					order_id = null,
					name = "Chicken Burger",
					quantity = 3L,
					note = null,
					price = 5.99
				)
			)
		)

		val requestEntity = HttpEntity<CreateOrderRequest>(body, headers)
		val actualResponse = restTemplate.exchange(
			"/orders/v1/orders",
			HttpMethod.POST,
			requestEntity,
			CreateOrderResponse::class.java
		)

		assertEquals(HttpStatus.OK, actualResponse.statusCode)

		val expectedResponse = CreateOrderResponse(
			orderId =  1,
			items = listOf(
				Item(
					id = null,
					order_id = null,
					name = "Chicken Burger",
					quantity = 3L,
					note = null,
					price = 5.99
				)
			)
		)
		assertEquals(expectedResponse, actualResponse.body, "Unexpected order created...")
	}
}



