package com.task.pulley.core.service.command

import com.task.pulley.core.domain.Piece
import com.task.pulley.core.port.`in`.command.CreatePieceCommand
import com.task.pulley.core.port.`in`.command.CreatePieceUseCase
import com.task.pulley.core.port.out.PieceCommandPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CreatePieceService(
    private val pieceCommandPort: PieceCommandPort
) : CreatePieceUseCase {
    override fun createPiece(command: CreatePieceCommand): Piece {
        return pieceCommandPort.createPiece(
            Piece(
                pieceId = command.pieceId,
                teacherId = command.userId,
                name = command.name,
                problemIds = command.problems
            )
        )
    }
}
