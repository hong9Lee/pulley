package com.task.pulley.core.port.out.query

import com.task.pulley.core.domain.Piece
import com.task.pulley.core.domain.support.EntityId

interface PieceQueryPort {
    fun findByPieceIdAndTeacherId(pieceId: EntityId, teacherId: EntityId): Piece
}
