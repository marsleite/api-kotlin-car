package com.example.car.app.controller

import com.example.car.app.dto.DriverDTO
import com.example.car.domain.entity.Driver
import com.example.car.domain.useCase.DriverAPIService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class DriverAPI(
    val driverAPIService: DriverAPIService
) {

    @GetMapping("/api/v1/drivers")
    private fun getListDrivers(): List<DriverDTO> = driverAPIService.getListAllDrivers()

    @GetMapping("api/v1/drivers/{id}")
    private fun getDriverById(@PathVariable("id") driverId: Long): DriverDTO = driverAPIService.getDriverById(driverId)

    @PostMapping("api/v1/driver/create")
    private fun createDriver(@RequestBody driver: Driver): ResponseEntity<Driver> {
        val driver = driverAPIService.createDriver(driver)
        return ResponseEntity.status(HttpStatus.CREATED).body(driver)
    }
}