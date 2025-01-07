package com.task.pulley.core.service.query

import com.task.pulley.core.domain.support.EntityId
import com.task.pulley.core.model.query.ProblemQueryModel
import com.task.pulley.core.port.`in`.query.PieceProblemQuery
import com.task.pulley.core.port.out.query.PieceQueryPort
import com.task.pulley.core.port.out.query.ProblemQueryPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PieceProblemQueryService(
    private val pieceQueryPort: PieceQueryPort,
    private val problemQueryPort: ProblemQueryPort
): PieceProblemQuery {

    override fun getPieceProblems(pieceId: EntityId): List<ProblemQueryModel> {
        val piece = pieceQueryPort.getProblemsByPieceId(pieceId)
        val problemIds = piece.problemIds.map { EntityId(it) }.toSet()

        return problemQueryPort.getProblemByIds(problemIds)
    }
}
