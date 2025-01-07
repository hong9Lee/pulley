package com.task.pulley.persistence.repository

import com.task.pulley.core.domain.support.EntityId
import com.task.pulley.persistence.entity.PieceAssignmentEntity
import org.springframework.data.repository.CrudRepository

interface PieceAssignmentRepository : CrudRepository<PieceAssignmentEntity, Long> {
    fun existsByPieceIdAndTeacherId(pieceId: EntityId, teacherId: EntityId): Boolean
    fun findAllByPieceId(pieceId: EntityId): List<PieceAssignmentEntity>
}
