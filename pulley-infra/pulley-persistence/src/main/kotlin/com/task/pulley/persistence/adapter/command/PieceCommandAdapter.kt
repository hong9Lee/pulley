package com.task.pulley.persistence.adapter.command

import com.task.pulley.core.domain.Piece
import com.task.pulley.core.port.out.PieceCommandPort
import com.task.pulley.persistence.entity.PieceEntity
import com.task.pulley.persistence.repository.PieceRepository
import org.springframework.stereotype.Repository

@Repository
class PieceCommandAdapter(
    private val pieceRepository: PieceRepository
) : PieceCommandPort {
    override fun createPiece(piece: Piece): Piece {
        return pieceRepository.save(PieceEntity.of(piece)).toDomain()
    }
}
