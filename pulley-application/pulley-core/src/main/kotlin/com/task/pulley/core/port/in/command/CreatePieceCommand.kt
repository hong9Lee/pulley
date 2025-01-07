package com.task.pulley.core.port.`in`.command

import com.task.pulley.core.domain.support.EntityId

data class CreatePieceCommand(
    val name: String,
    val pieceId: EntityId,
    val userId: EntityId,
    val problems: List<String>
)
