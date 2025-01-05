package com.task.pulley.persistence.repository

import com.task.pulley.persistence.entity.PieceAssignmentEntity
import org.springframework.data.repository.CrudRepository

interface PieceAssignmentRepository : CrudRepository<PieceAssignmentEntity, Long> {
}
