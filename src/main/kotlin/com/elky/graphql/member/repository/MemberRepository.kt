package com.elky.graphql.member.repository

import com.elky.graphql.member.domain.Member
import org.springframework.data.jpa.repository.JpaRepository


interface MemberRepository : JpaRepository<Member, Int>