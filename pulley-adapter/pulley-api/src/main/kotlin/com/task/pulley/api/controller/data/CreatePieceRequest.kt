package com.task.pulley.api.controller.data

import com.task.pulley.core.domain.support.EntityId
import com.task.pulley.core.port.`in`.command.CreatePieceCommand
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreatePieceRequest(

    @field:NotBlank(message = "학습지 이름은 필수입니다.")
    val name: String,

    @field:NotBlank(message = "유저 ID는 필수입니다.")
    val userId: String,

    @field:Size(max = 50, message = "문제는 최대 50개까지 포함될 수 있습니다.")
    val problems: List<String>
) {
    fun toCommand(): CreatePieceCommand {
        return CreatePieceCommand(
            name = name,
            userId = EntityId(userId),
            pieceId = EntityId(),
            problems = problems
        )
    }
}
