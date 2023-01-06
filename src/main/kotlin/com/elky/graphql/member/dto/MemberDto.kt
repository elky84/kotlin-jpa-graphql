package com.elky.graphql.member.dto

import com.elky.graphql.member.domain.Member
import java.util.stream.Collectors


data class MemberDto(val memberEmail: String?, val memberNumber: String?) {
}