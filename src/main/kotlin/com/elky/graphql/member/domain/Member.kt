package com.elky.graphql.member.domain

import jakarta.persistence.*

@Entity(name = "member")
class Member(sn: Int, id: String?, email: String?, number: String?) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val memberSn = sn

    @Column(nullable = false)
    val memberId = id

    @Column(nullable = false)
    val memberEmail = email

    @Column(nullable = false)
    val memberNumber = number

    constructor() : this(0, null, null, null)
}