package com.example.car.app.controller

import com.example.car.domain.entity.Driver
import com.example.car.domain.useCase.DriverAPIService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class DriverAPI(
    val driverAPIService: DriverAPIService
) {

    @GetMapping("/api/v1/drivers")
    private fun getListDrivers(): List<Driver> = driverAPIService.getListAllDrivers()

    @GetMapping("api/v1/drivers/{id}")
    private fun getDriverById(@PathVariable("id") driverId: Long): Driver = driverAPIService.getDriverById(driverId)
}