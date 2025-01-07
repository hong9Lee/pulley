package com.task.pulley.api.controller.data

import com.task.pulley.core.domain.support.EntityId
import com.task.pulley.core.port.`in`.command.AssignPieceCommand

data class AssignPieceRequest(
    val teacherId: String
) {
    fun toCommand(pieceId: String, studentIds: List<String>): AssignPieceCommand {
        return AssignPieceCommand(
            pieceId = EntityId(pieceId),
            teacherId = EntityId(teacherId),
            studentIds = studentIds.map { EntityId(it) }
        )
    }
}
