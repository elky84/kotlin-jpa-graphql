package com.elky.graphql.member.service

import com.elky.graphql.member.domain.Member
import com.elky.graphql.member.dto.MemberDto
import com.elky.graphql.member.repository.MemberRepository
import org.springframework.stereotype.Service
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.graphql.data.method.annotation.MutationMapping

@Service
class MemberMutation(val memberRepository: MemberRepository) : GraphQLMutationResolver {

    @MutationMapping
    fun registerMember(memberId: String?, memberEmail: String?, memberNumber: String?): MemberDto {
        val newMember = Member(memberId,
                memberEmail,
                memberNumber)
        memberRepository.save(newMember)
        return MemberDto.fromMember(newMember)
    }

    @MutationMapping
    fun deleteMember(memberId: String) : Boolean {
        return memberRepository.deleteByMemberId(memberId) != 0L
    }
}