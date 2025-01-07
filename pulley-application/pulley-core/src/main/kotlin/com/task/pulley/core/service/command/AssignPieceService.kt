package com.task.pulley.core.service.command

import com.task.pulley.core.port.`in`.command.AssignPieceCommand
import com.task.pulley.core.port.`in`.command.AssignPieceUseCase
import com.task.pulley.core.port.out.command.AssignPieceResult
import com.task.pulley.core.port.out.command.PieceAssignmentPort
import com.task.pulley.core.port.out.query.PieceQueryPort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class AssignPieceService(
    private val pieceQueryPort: PieceQueryPort,
    private val pieceAssignmentPort: PieceAssignmentPort,
): AssignPieceUseCase {
    override fun assignPiece(command: AssignPieceCommand): AssignPieceResult {
        /** 1. 선생님이 만든 학습지인지 확인 */
        val piece = pieceQueryPort.findByPieceIdAndTeacherId(command.pieceId, command.teacherId)

        /** 2. 이미 출제된 학생 필터링 */
        val existingStudents = pieceAssignmentPort.getAssignedStudents(piece.pieceId)
        val (skippedStudents, newStudents) = command.studentIds.partition { it in existingStudents }

        /** 3. 새로운 학생들에게 학습지 출제 */
        pieceAssignmentPort.assignPiece(piece.pieceId, piece.teacherId, newStudents)

        return AssignPieceResult(
            assignedStudents = newStudents,
            skippedStudents = skippedStudents
        )
    }
}
