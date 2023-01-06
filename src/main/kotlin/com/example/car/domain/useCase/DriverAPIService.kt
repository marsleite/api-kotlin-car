package com.example.car.domain.useCase

import com.example.car.domain.entity.Driver
import com.example.car.domain.repository.DriverRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class DriverAPIService(
    val driverRepository: DriverRepository
) {

    fun getListAllDrivers(): List<Driver> {
        return driverRepository.findAll()
    }

    fun getDriverById(driverId: Long): Driver {
        return driverRepository.findById(driverId).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }
}