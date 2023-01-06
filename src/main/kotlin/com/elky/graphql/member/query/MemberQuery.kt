package com.elky.graphql.member.query

import com.elky.graphql.member.domain.Member
import com.elky.graphql.member.dto.MemberDto
import com.elky.graphql.member.repository.MemberCustom
import com.elky.graphql.member.repository.MemberRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Service


@Service
class MemberQuery(val memberRepository: MemberRepository,
                  val memberCustom: MemberCustom
) : GraphQLQueryResolver{

    @QueryMapping
    fun findMember(memberId: String): Member? {
        return memberRepository.findByMemberId(memberId)
    }

    @QueryMapping
    fun queryMembers(memberDto: MemberDto?): List<Member> {
        return memberCustom.search(memberDto)
    }

    @QueryMapping
    fun allMembers(): List<Member> {
        return memberRepository.findAll()
    }
}