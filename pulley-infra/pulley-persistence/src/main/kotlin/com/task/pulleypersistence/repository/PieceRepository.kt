package com.task.pulleypersistence.repository

import com.task.pulleypersistence.entity.PieceEntity
import org.springframework.data.repository.CrudRepository

interface PieceRepository : CrudRepository<PieceEntity, Long> {
}
