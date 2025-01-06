package com.task.pulley.core.port.`in`.query

import com.task.pulley.core.domain.enums.ProblemType
import com.task.pulley.core.domain.enums.UnitCodeType

data class GetProblemsQueryRequest(
    val totalCount: Int,
    val unitCodes: Set<UnitCodeType>,
    val level: String,
    val problemTypes: Set<ProblemType>
) {
    companion object {
        fun of(
            totalCount: Int,
            unitCodeList: List<String>,
            level: String,
            problemType: String
        ): GetProblemsQueryRequest {
            return GetProblemsQueryRequest(
                totalCount = totalCount,
                unitCodes = getUnitCodes(unitCodeList),
                level = level,
                problemTypes = getProblemTypes(problemType)
            )

        }

        private fun getUnitCodes(unitCodes: List<String>): Set<UnitCodeType> =
            unitCodes.mapNotNull { code ->
                UnitCodeType.fromCode(code.uppercase())
            }.toSet()

        private fun getProblemTypes(problemType: String) =
            when {
                problemType.uppercase() == "ALL" -> {
                    ProblemType.entries.toSet()
                }

                else -> {
                    setOf(ProblemType.valueOf(problemType.uppercase()))
                }
            }
    }
}
