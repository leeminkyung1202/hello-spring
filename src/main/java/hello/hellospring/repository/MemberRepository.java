package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional; // 데이터가 없으면 NULL로 반환되는데, Optional로 감싸서 반환되는 방법을 선호

public interface MemberRepository {
    /**
     *
     * @param member
     * @return
     */
    Member save(Member member); // 회원을 저장하고, 저장된 회원 반환
    Optional<Member> findById(Long id); // 저장된 회원 id로 찾기
    Optional<Member> findByName(String name); // 저장된 회원 name으로 찾기
    List<Member> findAll(); // 저장 된 모든 회원 리스트 반환
}
