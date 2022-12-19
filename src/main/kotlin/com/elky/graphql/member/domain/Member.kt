package com.elky.graphql.member.domain

import jakarta.persistence.*

@Entity(name = "member")
class Member(id: String?, email: String?, number: String?) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val memberSn = 0

    @Column(nullable = false)
    val memberId = id

    @Column(nullable = false)
    val memberEmail = email

    @Column(nullable = false)
    val memberNumber = number

    constructor() : this(null, null, null)
}