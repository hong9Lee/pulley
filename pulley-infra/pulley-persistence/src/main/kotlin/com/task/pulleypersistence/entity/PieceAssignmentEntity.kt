package com.task.pulleypersistence.entity

import com.task.pulleycore.domain.PieceAssignment
import com.task.pulleycore.domain.support.EntityId
import com.task.pulleypersistence.entity.base.BaseTimeEntity
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
    @AttributeOverride(name = "value", column = Column(name = "student_id"))
    val studentId: EntityId,

    @Column(name = "status")
    val status: String
) : BaseTimeEntity() {

    companion object {
        fun of(assignment: PieceAssignment): PieceAssignmentEntity {
            return PieceAssignmentEntity(
                assignment.assignmentId,
                assignment.pieceId,
                assignment.studentId,
                assignment.status
            )
        }
    }

    fun toDomain(): PieceAssignment {
        return PieceAssignment(
            assignmentId = this.assignmentId,
            pieceId = this.pieceId,
            studentId = this.studentId,
            status = this.status,
        )
    }
}
