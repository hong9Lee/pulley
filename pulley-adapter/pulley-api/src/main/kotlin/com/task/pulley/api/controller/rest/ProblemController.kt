package com.task.pulley.api.controller.rest

import com.task.pulley.api.supports.UrlConstants
import com.task.pulley.core.port.`in`.query.ProblemQuery
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProblemController(
    private val problemQuery: ProblemQuery
) {

    @GetMapping(UrlConstants.문제_조회)
    fun getProblems() {

    }
}
