package com.task.pulley.persistence.supports

import com.fasterxml.jackson.core.type.TypeReference

class ListStringConverter : GenericJsonConverter<List<String>>(
    object : TypeReference<List<String>>() {}
)
