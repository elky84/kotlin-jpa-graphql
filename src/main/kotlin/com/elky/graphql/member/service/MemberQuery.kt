package com.elky.graphql.member.service

import com.elky.graphql.member.domain.Member
import com.elky.graphql.member.dto.MemberDto
import com.elky.graphql.member.repository.MemberRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Service


@Service
class MemberQuery(val memberRepository: MemberRepository) : GraphQLQueryResolver{

    @QueryMapping
    fun findMember(memberId: String): MemberDto? {
        val member = memberRepository.findByMemberId(memberId) ?: return null
        return MemberDto.fromMember(member)
    }

    @QueryMapping
    fun allFindMembers(): List<MemberDto> {
        val members = memberRepository.findAll()
        return MemberDto.fromMemberList(members)
    }
}