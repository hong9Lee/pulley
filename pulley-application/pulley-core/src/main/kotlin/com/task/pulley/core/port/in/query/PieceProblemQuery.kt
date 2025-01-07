package com.task.pulley.core.port.`in`.query

import com.task.pulley.core.domain.support.EntityId
import com.task.pulley.core.model.query.ProblemQueryModel

interface PieceProblemQuery {
    fun getPieceProblems(pieceId: EntityId): List<ProblemQueryModel>
}
