package com.example.car.domain.useCase

import com.example.car.app.dto.DriverDTO
import com.example.car.domain.entity.Driver
import com.example.car.domain.repository.DriverRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import java.time.LocalDateTime
import java.time.Month

@ExtendWith(MockKExtension::class)
class DriverAPIServiceTest {

    @MockK
    private lateinit var driverRepository: DriverRepository

    @InjectMockKs
    private lateinit var target: DriverAPIService
    @Test
    fun testGetListAllDrivers() {
        //given
        val dateTest = LocalDateTime.of(2023, Month.JANUARY,10, 12, 12, 12)
        val driver1 = Driver(1, "Marcelo", dateTest)
        val driver2 = Driver(2, "Rebeca", dateTest)

        val driver1DTO = DriverDTO("Marcelo", dateTest)
        val driver2DTO = DriverDTO("Rebeca", dateTest)

        //when
        every {
            driverRepository.findAll()
        } returns listOf(driver1, driver2)

        //then
        val response = target.getListAllDrivers()
        assertEquals(listOf(driver1DTO, driver2DTO), response)
    }

    @Test
    fun getDriverById() {
    }

    @Test
    fun createDriver() {
    }

    @Test
    fun updateDriver() {
    }

    @Test
    fun patchDriver() {
    }

    @Test
    fun deleteDriver() {
    }
}