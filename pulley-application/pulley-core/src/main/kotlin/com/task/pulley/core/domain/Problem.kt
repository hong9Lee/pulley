package com.task.pulley.core.domain

import com.task.pulley.core.domain.enums.ProblemType
import com.task.pulley.core.domain.support.EntityId

data class Problem(
    val seq: Long? = null,
    val problemId: EntityId,
    val pieceId: EntityId,
    val unitCode: String,
    val level: Int,
    val problemType: ProblemType,
    val answer: String,
)
