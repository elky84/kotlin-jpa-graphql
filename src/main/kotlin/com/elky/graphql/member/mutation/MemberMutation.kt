package com.elky.graphql.member.mutation

import com.elky.graphql.member.domain.Member
import com.elky.graphql.member.repository.MemberRepository
import org.springframework.stereotype.Service
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.graphql.data.method.annotation.MutationMapping

@Service
class MemberMutation(val memberRepository: MemberRepository) : GraphQLMutationResolver {

    @MutationMapping
    fun createMember(memberId: String?, memberEmail: String?, memberNumber: String?): Member {
        val newMember = Member(memberId,
                memberEmail,
                memberNumber)
        return memberRepository.save(newMember)
    }

    @MutationMapping
    fun deleteMember(memberId: String) : Boolean {
        return memberRepository.deleteByMemberId(memberId) != 0L
    }
}