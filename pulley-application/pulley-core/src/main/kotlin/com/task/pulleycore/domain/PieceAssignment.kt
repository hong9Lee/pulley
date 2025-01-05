package com.task.pulleycore.domain

import com.task.pulleycore.domain.support.EntityId

data class PieceAssignment(
    val seq: Long? = null,
    val assignmentId: EntityId,
    val pieceId: EntityId,
    val studentId: EntityId,
    val status: String,
)
