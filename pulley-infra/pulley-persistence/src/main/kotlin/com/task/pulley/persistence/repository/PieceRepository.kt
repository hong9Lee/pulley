package com.task.pulley.persistence.repository

import com.task.pulley.persistence.entity.PieceEntity
import org.springframework.data.repository.CrudRepository

interface PieceRepository : CrudRepository<PieceEntity, Long> {
}
