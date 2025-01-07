package com.task.pulley.persistence.entity

import com.task.pulley.core.domain.PieceAssignment
import com.task.pulley.core.domain.enums.AssignStatus
import com.task.pulley.core.domain.support.EntityId
import com.task.pulley.persistence.entity.base.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "piece_assignment")
class PieceAssignmentEntity(
    @Embedded
    @AttributeOverride(name = "value", column = Column(name = "assignment_id"))
    private val assignmentId: EntityId,

    @Embedded
    @AttributeOverride(name = "value", column = Column(name = "piece_id"))
    val pieceId: EntityId,

    @Embedded
    @AttributeOverride(name = "value", column = Column(name = "teacher_id"))
    val teacherId: EntityId,

    @Embedded
    @AttributeOverride(name = "value", column = Column(name = "student_id"))
    val studentId: EntityId,

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    val status: AssignStatus
) : BaseTimeEntity() {

    companion object {
        fun of(assignment: PieceAssignment): PieceAssignmentEntity {
            return PieceAssignmentEntity(
                assignment.assignmentId,
                assignment.pieceId,
                assignment.teacherId,
                assignment.studentId,
                assignment.status
            )
        }
    }

    fun toDomain(): PieceAssignment {
        return PieceAssignment(
            assignmentId = this.assignmentId,
            pieceId = this.pieceId,
            teacherId = this.teacherId,
            studentId = this.studentId,
            status = this.status,
        )
    }
}
