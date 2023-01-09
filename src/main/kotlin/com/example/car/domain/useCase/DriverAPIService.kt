package com.example.car.domain.useCase

import com.example.car.app.dto.DriverDTO
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

//    fun createDriver(driver: Driver): Driver {
//        return driverDTOBuilder.save(driver)
//    }
}