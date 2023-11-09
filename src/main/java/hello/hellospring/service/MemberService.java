package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {
     private final MemberRepository memberRepository;

     public MemberService(MemberRepository memberRepository) {
         this.memberRepository = memberRepository;
     }

    /**
     * 회원 가입
     * @param member
     * @return
     */
     public Long join(Member member) {
         validateDuplicateMember(member); // 중복 회원 검증
         memberRepository.save(member); // 정보 저장
         return member.getId(); // 저장 후 id 리턴
     }

    /**
     * 중복 회원 있는지 체크
     * @param member
     */
    private void validateDuplicateMember(Member member) {
         /*
         Optional<Member> result = memberRepository.findByName(member.getName());
         // null이 아니라 멤버에 값이 있으면 동작함. 만약 optional을 안해줬다면, if null 체크가 필요함.
         result.ifPresent(m -> {
             throw new IllegalStateException("이미 존재하는 회원 입니다.");
         });
          */
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원 입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers() {
         return memberRepository.findAll();
    }

    /**
     * 조회한 회원 리스트
     * @param memberId
     * @return
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
