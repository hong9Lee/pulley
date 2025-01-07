package com.task.pulley.support

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class ZonedDateTimeUtils {
    companion object {
        private val SEOUL_ZONE_ID: ZoneId = ZoneId.of("Asia/Seoul")
        val DATE_TIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        fun nowOfSeoul(): ZonedDateTime {
            return ofSeoul(LocalDateTime.now())
        }

        fun ofSeoul(localDateTime: LocalDateTime): ZonedDateTime {
            return ZonedDateTime.of(localDateTime, SEOUL_ZONE_ID)
        }

        fun convert(value: ZonedDateTime): String {
            return DATE_TIME_FORMATTER.format(value)
        }
    }
}
