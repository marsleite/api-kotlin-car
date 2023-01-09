package com.example.car.domain.repository

import com.example.car.app.dto.DriverDTO
import com.example.car.domain.entity.Driver
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

interface DriverRepository: JpaRepository<Driver, Long> {
}