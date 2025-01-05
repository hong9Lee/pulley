package com.task.pulleypersistence.repository

import com.task.pulleypersistence.entity.PieceAssignmentEntity
import org.springframework.data.repository.CrudRepository

interface PieceAssignmentRepository : CrudRepository<PieceAssignmentEntity, Long> {
}
