package com.task.pulley.core.port.`in`.command

import com.task.pulley.core.domain.Piece

interface CreatePieceUseCase {
    fun createPiece(command: CreatePieceCommand): Piece
}
