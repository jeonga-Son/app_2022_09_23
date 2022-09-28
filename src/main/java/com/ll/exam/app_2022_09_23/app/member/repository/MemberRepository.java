package com.ll.exam.app_2022_09_23.app.member.repository;

import com.ll.exam.app_2022_09_23.app.member.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// @Mapper는 마커 인터페이스라는 것이다. * 마커 인터페이스: 기능이 있는게 아니라 마커, 즉 무언가 표시를 하기 위한 인터페이스를 의미한다.
// 즉, @Mapper는 단순히 '이것은 매퍼입니다!!' 라는 것을 표시하기 위한 어노테이션이라는 것이다.
@Mapper
public interface MemberRepository {
    @Select("""
            SELECT *
            FROM member
            WHERE username = #{username}
            """)
    Member getMemberByUsername(String username);
}