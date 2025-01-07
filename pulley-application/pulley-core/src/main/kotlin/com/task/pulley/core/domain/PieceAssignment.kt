package com.task.pulley.core.domain

import com.task.pulley.core.domain.enums.AssignStatus
import com.task.pulley.core.domain.support.EntityId

data class PieceAssignment(
    val seq: Long? = null,
    val assignmentId: EntityId,
    val pieceId: EntityId,
    val teacherId: EntityId,
    val studentId: EntityId,
    val status: AssignStatus,
)
