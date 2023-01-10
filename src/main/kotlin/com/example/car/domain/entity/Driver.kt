package com.example.car.domain.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Driver(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    val name: String?,
    val birthDay: LocalDateTime?
) {
}