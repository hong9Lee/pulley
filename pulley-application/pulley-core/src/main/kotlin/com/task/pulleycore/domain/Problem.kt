package com.task.pulleycore.domain

import com.task.pulleycore.domain.enums.ProblemType
import com.task.pulleycore.domain.support.EntityId

data class Problem(
    val seq: Long? = null,
    val problemId: EntityId,
    val pieceId: EntityId,
    val unitCode: String,
    val level: Int,
    val problemType: ProblemType,
    val answer: String,
)
