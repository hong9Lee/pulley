package com.task.pulley.core.port.`in`.command

import com.task.pulley.core.port.out.command.AssignPieceResult

interface AssignPieceUseCase {
    fun assignPiece(command: AssignPieceCommand): AssignPieceResult
}
