package com.task.pulley.persistence.adapter.command

import com.task.pulley.core.domain.PieceAssignment
import com.task.pulley.core.domain.enums.AssignStatus
import com.task.pulley.core.domain.support.EntityId
import com.task.pulley.core.port.out.command.PieceAssignmentPort
import com.task.pulley.persistence.entity.PieceAssignmentEntity
import com.task.pulley.persistence.repository.PieceAssignmentRepository
import org.springframework.stereotype.Repository

@Repository
class PieceAssignmentAdapter(
    private val pieceAssignmentRepository: PieceAssignmentRepository
) : PieceAssignmentPort {
    override fun isCreatedByTeacher(pieceId: EntityId, teacherId: EntityId): Boolean {
        return pieceAssignmentRepository.existsByPieceIdAndTeacherId(pieceId, teacherId)
    }

    override fun getAssignedStudents(pieceId: EntityId): List<EntityId> {
        return pieceAssignmentRepository.findAllByPieceId(pieceId).map { it.studentId }
    }

    override fun assignPiece(pieceId: EntityId, teacherId: EntityId, studentIds: List<EntityId>) {
        pieceAssignmentRepository.saveAll(studentIds.map { studentId ->
            PieceAssignmentEntity.of(
                PieceAssignment(
                    assignmentId = EntityId(),
                    pieceId = pieceId,
                    teacherId = teacherId,
                    studentId = studentId,
                    status = AssignStatus.ASSIGNED
                )
            )
        })
    }
}
