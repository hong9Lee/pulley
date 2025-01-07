package com.task.pulley.persistence.adapter.query

import com.task.pulley.core.domain.Piece
import com.task.pulley.core.domain.support.EntityId
import com.task.pulley.core.port.out.query.PieceQueryPort
import com.task.pulley.persistence.repository.query.PieceQueryRepository
import org.springframework.stereotype.Repository

@Repository
class PieceQueryAdapter(
    private val pieceQueryRepository: PieceQueryRepository
) : PieceQueryPort {

    override fun findByPieceIdAndTeacherId(pieceId: EntityId, teacherId: EntityId): Piece {
        return pieceQueryRepository.findByPieceIdAndTeacherId(pieceId, teacherId)
            .let { it ?: throw IllegalArgumentException("학습지가 존재하지 않습니다. (pieceId: $pieceId, teacherId: $teacherId)") }
    }

    override fun getProblemsByPieceId(pieceId: EntityId): Piece {
        return pieceQueryRepository.findByPieceId(pieceId)
            ?: throw IllegalArgumentException("학습지가 존재하지 않습니다: $pieceId")
    }
}
