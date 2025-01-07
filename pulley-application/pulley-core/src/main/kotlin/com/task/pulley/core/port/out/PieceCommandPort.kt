package com.task.pulley.core.port.out

import com.task.pulley.core.domain.Piece

interface PieceCommandPort {
    fun createPiece(piece: Piece): Piece
}
