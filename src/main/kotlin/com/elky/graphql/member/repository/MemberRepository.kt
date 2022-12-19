package com.elky.graphql.member.repository

import com.elky.graphql.member.domain.Member
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository


interface MemberRepository : JpaRepository<Member, Int>{
    fun findByMemberId(memberId: String): Member?

    @Transactional
    fun deleteByMemberId(memberId: String): Long
}