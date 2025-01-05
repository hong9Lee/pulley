package com.task.pulleypersistence.entity

import com.task.pulleycore.domain.Problem
import com.task.pulleycore.domain.enums.ProblemType
import com.task.pulleycore.domain.support.EntityId
import com.task.pulleypersistence.entity.base.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "problem")
class ProblemEntity(
    @Embedded
    @AttributeOverride(name = "value", column = Column(name = "problem_id"))
    private val problemId: EntityId,

    @Embedded
    @AttributeOverride(name = "value", column = Column(name = "piece_id"))
    val pieceId: EntityId,

    @Column(name = "unit_code")
    val unitCode: String,

    @Column(name = "level")
    val level: Int,

    @Column(name = "problem_type")
    @Enumerated(EnumType.STRING)
    val problemType: ProblemType,

    @Column(name = "answer")
    val answer: String,

    ) : BaseTimeEntity() {

    companion object {
        fun of(problem: Problem): ProblemEntity {
            return ProblemEntity(
                problem.problemId,
                problem.pieceId,
                problem.unitCode,
                problem.level,
                problem.problemType,
                problem.answer,
            )
        }
    }

    fun toDomain(): Problem {
        return Problem(
            problemId = this.problemId,
            pieceId = this.pieceId,
            unitCode = this.unitCode,
            level = this.level,
            problemType = this.problemType,
            answer = this.answer
        )
    }
}
