package com.task.pulley.api.controller.data

import com.task.pulley.core.domain.support.EntityId

data class AssignPieceResponse(
    val assignedStudents: List<String>,
    val skippedStudents: List<String>
) {
    companion object {
        fun of(assigned: List<EntityId>, skipped: List<EntityId>): AssignPieceResponse {
            return AssignPieceResponse(
                assignedStudents = assigned.map { it.value },
                skippedStudents = skipped.map { it.value }
            )
        }
    }
}
