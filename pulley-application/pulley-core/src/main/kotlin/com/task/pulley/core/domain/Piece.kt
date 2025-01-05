package com.task.pulley.core.domain

import com.task.pulley.core.domain.support.EntityId

data class Piece(
    val seq: Long? = null,
    val pieceId: EntityId,
    val teacherId: EntityId,
    val name: String,
)
