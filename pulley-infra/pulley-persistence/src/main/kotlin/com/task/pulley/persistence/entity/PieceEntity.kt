package com.task.pulley.persistence.entity

import com.task.pulley.core.domain.Piece
import com.task.pulley.core.domain.support.EntityId
import com.task.pulley.persistence.entity.base.BaseTimeEntity
import com.task.pulley.persistence.supports.ListStringConverter
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
    val name: String,

    @Column(name = "problem_ids")
    @Convert(converter = ListStringConverter::class)
    private val problemIds: List<String>

) : BaseTimeEntity() {

    companion object {
        fun of(piece: Piece): PieceEntity {
            return PieceEntity(
                pieceId = piece.pieceId,
                teacherId = piece.teacherId,
                name = piece.name,
                problemIds = piece.problemIds
            )
        }
    }

    fun toDomain(): Piece {
        return Piece(
            pieceId = this.pieceId,
            name = this.name,
            teacherId = this.teacherId,
            problemIds = this.problemIds
        )
    }
}
