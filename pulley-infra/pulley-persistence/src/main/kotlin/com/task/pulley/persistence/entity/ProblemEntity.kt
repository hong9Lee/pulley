package com.task.pulley.persistence.entity

import com.task.pulley.core.domain.Problem
import com.task.pulley.core.domain.enums.ProblemType
import com.task.pulley.core.domain.enums.UnitCodeType
import com.task.pulley.core.domain.support.EntityId
import com.task.pulley.persistence.entity.base.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "problem")
class ProblemEntity(
    @Embedded
    @AttributeOverride(name = "value", column = Column(name = "problem_id"))
    private val problemId: EntityId,

    @Column(name = "unit_code")
    @Enumerated(EnumType.STRING)
    val unitCode: UnitCodeType,

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
            unitCode = this.unitCode,
            level = this.level,
            problemType = this.problemType,
            answer = this.answer
        )
    }
}
