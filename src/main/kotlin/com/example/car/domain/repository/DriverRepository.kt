package com.example.car.domain.repository

import com.example.car.domain.entity.Driver
import org.springframework.data.jpa.repository.JpaRepository

interface DriverRepository: JpaRepository<Driver, Long> {
}