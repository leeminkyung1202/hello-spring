package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // sequence는 0,1,2.. 키값을 생성해줌.

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 저장 시 id 값을 올려줌.
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // 회원 리스트를 꺼내서 루프 돌림
                .filter(member -> member.getName().equals(name)) // 검색한 name과 같은 값인지 확인
                .findAny(); // 찾으면 바로 반환 (없으면 Optional로 감싸서 NULL 반환)
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
