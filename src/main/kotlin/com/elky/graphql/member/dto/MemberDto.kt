package com.elky.graphql.member.dto

import com.elky.graphql.member.domain.Member
import java.util.stream.Collectors


class MemberDto(sn: Int, id: String?, email: String?, number: String?) {
    val memberSn = sn
    val memberId = id
    val memberEmail = email
    val memberNumber = number

    companion object {
        fun fromMember(member: Member): MemberDto {
            return MemberDto(member.memberSn,
                    member.memberId,
                    member.memberEmail,
                    member.memberNumber)
        }

        fun fromMemberList(members: Collection<Member>): List<MemberDto> {
            return members.stream().map { member: Member ->
                fromMember(
                    member
                )
            }.collect(Collectors.toList())
        }
    }
}