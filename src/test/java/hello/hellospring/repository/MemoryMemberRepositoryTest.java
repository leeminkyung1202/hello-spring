package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        // 메소드 실행 종료 시 실행되는 어노테이션
        // 테스트 케이스를 전체 실행 시 순서 보장이 안된다. 그래서 실행 종료 시 공용 데이터나 저장소를 클리어 해주는 코드가 필요함
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result); //import org.assertj.core.api.Assertions;

        // 기대한 데이터(member)와 리턴된 데이터(result) 비교. 성공 => 빌드에 녹색불 / 실패 => 빌드에 에러
        //Assertions.assertEquals(member, result); //import org.junit.jupiter.api.Assertions;

        // 두개의 데이터 비교.
        //System.out.println("result = " + (result == member));
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
