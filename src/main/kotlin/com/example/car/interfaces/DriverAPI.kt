package com.example.car.interfaces

import com.example.car.domain.entity.Driver
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Service
@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class DriverAPI {

    @GetMapping("/api/v1/drivers")
    fun listDrivers(): List<Driver> = emptyList()
}