package com.task.pulleycore.domain

import com.task.pulleycore.domain.support.EntityId

data class Piece(
    val seq: Long? = null,
    val pieceId: EntityId,
    val teacherId: EntityId,
    val name: String,
)
