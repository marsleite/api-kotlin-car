package com.example.car.domain.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Driver(

    @Id
    var id: Long? = null,
    val name: String,
    val birthDay: LocalDateTime
) {
}