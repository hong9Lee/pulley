package com.task.pulley.persistence.repository.query.result

import com.querydsl.core.annotations.QueryProjection
import com.task.pulley.core.domain.enums.ProblemType
import com.task.pulley.core.domain.enums.UnitCodeType
import com.task.pulley.core.domain.support.EntityId
import com.task.pulley.core.model.query.ProblemQueryModel

data class ProblemQueryResult @QueryProjection constructor(
    val problemId: EntityId,
    val pieceId: EntityId,
    val unitCode: UnitCodeType,
    val level: Int,
    val problemType: ProblemType,
    val answer: String
) {
    fun toModel(): ProblemQueryModel {
        return ProblemQueryModel(
            problemId = problemId,
            pieceId = pieceId,
            unitCode = unitCode,
            level = level,
            problemType = problemType,
            answer = answer
        )
    }
}
