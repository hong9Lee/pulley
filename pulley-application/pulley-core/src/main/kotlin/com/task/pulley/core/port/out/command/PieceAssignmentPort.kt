package com.task.pulley.core.port.out.command

import com.task.pulley.core.domain.support.EntityId

interface PieceAssignmentPort {
    fun isCreatedByTeacher(pieceId: EntityId, teacherId: EntityId): Boolean
    fun getAssignedStudents(pieceId: EntityId): List<EntityId>
    fun assignPiece(pieceId: EntityId, teacherId: EntityId, studentIds: List<EntityId>)
}
