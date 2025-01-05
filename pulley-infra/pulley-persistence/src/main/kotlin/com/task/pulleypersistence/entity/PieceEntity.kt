package com.task.pulleypersistence.entity

import com.task.pulleycore.domain.Piece
import com.task.pulleycore.domain.support.EntityId
import com.task.pulleypersistence.entity.base.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "piece")
class PieceEntity(
    @Embedded
    @AttributeOverride(name = "value", column = Column(name = "piece_id"))
    private val pieceId: EntityId,

    @Embedded
    @AttributeOverride(name = "value", column = Column(name = "teacher_id"))
    val teacherId: EntityId,

    @Column(name = "name")
    val name: String
) : BaseTimeEntity() {

    companion object {
        fun of(piece: Piece): PieceEntity {
            return PieceEntity(
                pieceId = piece.pieceId,
                teacherId = piece.teacherId,
                name = piece.name
            )
        }
    }

    fun toDomain(): Piece {
        return Piece(
            pieceId = this.pieceId,
            name = this.name,
            teacherId = this.teacherId
        )
    }
}
