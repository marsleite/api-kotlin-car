package com.example.car.domain.useCase

import com.example.car.domain.entity.Driver
import com.example.car.domain.repository.DriverRepository
import org.springframework.stereotype.Service

@Service
class DriverAPIService(
    val driverRepository: DriverRepository
) {

    fun getListAllDrivers(): List<Driver> {
        return driverRepository.findAll()
    }
}