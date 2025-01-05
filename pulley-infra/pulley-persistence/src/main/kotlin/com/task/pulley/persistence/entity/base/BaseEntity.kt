package com.task.pulley.persistence.entity.base

import jakarta.persistence.*

@MappedSuperclass
abstract class BaseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false, updatable = false)
    open var seq: Long? = null
)
