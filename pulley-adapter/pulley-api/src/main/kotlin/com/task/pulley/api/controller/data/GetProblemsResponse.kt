package com.task.pulley.api.controller.data

import com.task.pulley.core.model.query.ProblemQueryModel

data class GetProblemsResponse(
    val problemList: List<GetProblemData>
) {
    companion object {
        fun of(model: List<ProblemQueryModel>) = GetProblemsResponse(
            problemList = model
                .sortedWith(
                    compareBy<ProblemQueryModel> { it.unitCode.name }
                        .thenBy { it.problemType.name }
                        .thenBy { it.level }
                )
                .map { GetProblemData.of(it) }
        )
    }

    data class GetProblemData(
        val id: String,
        val answer: String,
        val unitCode: String,
        val level: String,
        val problemType: String
    ) {
        companion object {

            fun of(model: ProblemQueryModel): GetProblemData {
                return GetProblemData(
                    id = model.problemId.value,
                    answer = model.answer,
                    unitCode = model.unitCode.name,
                    level = model.level.toString(),
                    problemType = model.problemType.name
                )
            }
        }
    }
}
