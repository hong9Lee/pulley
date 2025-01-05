package com.task.pulley.persistence.repository

import com.task.pulley.persistence.entity.UsersEntity
import org.springframework.data.repository.CrudRepository

interface UsersRepository: CrudRepository<UsersEntity, Long> {
}
