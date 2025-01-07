package com.task.pulley.core.port.`in`.command

import com.task.pulley.core.domain.support.EntityId

data class AssignPieceCommand(
    val pieceId: EntityId,
    val teacherId: EntityId,
    val studentIds: List<EntityId>
)
