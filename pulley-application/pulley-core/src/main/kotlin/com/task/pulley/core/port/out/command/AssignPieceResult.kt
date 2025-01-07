package com.task.pulley.core.port.out.command

import com.task.pulley.core.domain.support.EntityId

data class AssignPieceResult(
    val assignedStudents: List<EntityId>,
    val skippedStudents: List<EntityId>
)
