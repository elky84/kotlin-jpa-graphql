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
    fun registerMember(memberSn: Int, memberId: String?, memberEmail: String?, memberNumber: String?): MemberDto {
        val newMember = Member(memberSn,
                memberId,
                memberEmail,
                memberNumber)
        memberRepository.save(newMember)
        return MemberDto.fromMember(newMember)
    }

    @MutationMapping
    fun deleteMember(memberId: String?): Boolean {
        val memberList: List<Member> = memberRepository.findAll()
        var deleteChk = 0
        for (member in memberList) {
            if (member.memberId.equals(memberId)) {
                memberRepository.delete(member)
                deleteChk += 1
            }
        }
        return deleteChk > 0
    }
}