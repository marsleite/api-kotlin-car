package com.example.car.domain.useCase

import com.example.car.app.dto.DriverDTO
import com.example.car.domain.entity.Driver
import com.example.car.domain.repository.DriverRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class DriverAPIService(
    private val driverRepository: DriverRepository
) {

    fun getListAllDrivers(): List<DriverDTO> {
        return driverRepository.findAll().map { DriverDTO(it.name, it.birthDay) }
    }

    fun getDriverById(driverId: Long): DriverDTO {
        val driver = driverRepository.findById(driverId).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND)
        }
        return DriverDTO(driver.name, driver.birthDay)
    }

    fun createDriver(driver: Driver): Driver {
        return driverRepository.save(driver)
    }

    fun updateDriver(driverId: Long, driver: Driver): Driver {
        val foundDriver = driverRepository.findById(driverId).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND)
        }

        val copyDriver = foundDriver.copy(
            name = driver.name,
            birthDay = driver.birthDay
        )

        return driverRepository.save(copyDriver)
    }

    fun patchDriver(driver: Driver, driverId: Long): Driver {
        val foundDriver = driverRepository.findById(driverId).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND)
        }

        val copyDriver = foundDriver.copy(
            name = driver.name ?: foundDriver.name,
            birthDay = driver.birthDay ?: foundDriver.birthDay
        )

        return driverRepository.save(copyDriver)
    }

    fun deleteDriver(driverId: Long): String {
        val foundDriver = driverRepository.findById(driverId).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND)
        }

        driverRepository.delete(foundDriver)

        return "deleted successfully"
    }
}