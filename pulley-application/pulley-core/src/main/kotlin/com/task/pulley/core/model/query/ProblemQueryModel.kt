package com.task.pulley.core.model.query

import com.task.pulley.core.domain.enums.ProblemType
import com.task.pulley.core.domain.enums.UnitCodeType
import com.task.pulley.core.domain.support.EntityId

data class ProblemQueryModel(
    val problemId: EntityId,
    val pieceId: EntityId,
    val unitCode: UnitCodeType,
    val level: Int,
    val problemType: ProblemType,
    val answer: String
)
