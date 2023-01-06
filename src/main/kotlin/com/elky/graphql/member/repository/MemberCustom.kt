package com.elky.graphql.member.repository

import com.elky.graphql.member.domain.Member
import com.elky.graphql.member.domain.QMember
import com.elky.graphql.member.dto.MemberDto
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class MemberCustom(private val jpaQueryFactory: JPAQueryFactory) {

    fun search(memberDto: MemberDto?) : List<Member> {
        val q = QMember.member
        if(memberDto == null)
            return jpaQueryFactory.selectFrom(q)
                .fetch()

        return jpaQueryFactory.selectFrom(q)
            .where(build(arrayListOf(numberContains(q, memberDto.memberNumber), emailContains(q, memberDto.memberEmail))))
            .fetch()
    }

    private fun build(expressions: List<BooleanExpression?>) : BooleanBuilder {
        val booleanBuilder = BooleanBuilder()
        for(expression in expressions) {
            if(expression != null) {
                booleanBuilder.or(expression)
            }
        }

        return booleanBuilder
    }

    private fun numberContains(q: QMember, memberNumber: String?) : BooleanExpression?
            = if (memberNumber != null) q.memberNumber.contains(memberNumber) else null

    private fun emailContains(q: QMember, memberEmail: String?) : BooleanExpression?
            = if (memberEmail != null) q.memberEmail.contains(memberEmail) else null
}