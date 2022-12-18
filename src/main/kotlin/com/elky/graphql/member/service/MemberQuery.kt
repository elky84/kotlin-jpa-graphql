package com.elky.graphql.member.service

import com.elky.graphql.member.domain.Member
import com.elky.graphql.member.dto.MemberDto
import com.elky.graphql.member.repository.MemberRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Service


@Service
class MemberQuery(val memberRepository: MemberRepository) : GraphQLQueryResolver{

    @QueryMapping
    fun findMembers(memberId: String): MemberDto {
        val members: List<Member> = memberRepository.findAll()
        var member = Member()
        for (newMember in members) {
            if (newMember.memberId.equals(memberId)) {
                member = memberRepository.findById(newMember.memberSn)
                    .orElse(null)
            }
        }
        return MemberDto.fromMember(member)
    }

    @QueryMapping
    fun allFindMembers(): List<MemberDto> {
        val members = memberRepository.findAll()
        return MemberDto.fromMemberList(members)
    }
}