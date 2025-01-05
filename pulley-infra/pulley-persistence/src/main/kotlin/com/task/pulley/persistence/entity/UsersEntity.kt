package com.task.pulley.persistence.entity

import com.task.pulley.core.domain.enums.UserRoleType
import com.task.pulley.core.domain.support.EntityId
import com.task.pulley.core.domain.Users
import com.task.pulley.persistence.entity.base.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "users")
class UsersEntity(
    @Embedded
    @AttributeOverride(name = "value", column = Column(name = "user_id"))
    private val userId: EntityId,

    @Column(name = "user_name")
    val userName: String,

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    val role: UserRoleType
) : BaseTimeEntity() {

    companion object {
        fun of(users: Users): UsersEntity {
            return UsersEntity(users.userId, users.username, users.role)
        }
    }

    fun toDomain(): Users {
        return Users(userId = this.userId, username = this.userName, role = this.role)
    }
}
