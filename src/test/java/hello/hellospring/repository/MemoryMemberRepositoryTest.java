package hello.hellospring.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

import hello.hellospring.domain.*;

public class MemoryMemberRepositoryTest {

	MemoryMemberRepository repository = new MemoryMemberRepository();

	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}

	@Test
	public void save() {
		Member member = new Member();
		member.setName("spirng");

		repository.save(member);

		Member result = repository.findById(member.getId()).get();

		// Assertions.assertEquals(member, result);
		assertThat(result).isEqualTo(member);
	}

	@Test
	public void findByName() {
		// given
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		// when
		Member result = repository.findByName("spring1").get();
		// then
		assertThat(result).isEqualTo(member1);
	}

	@Test
	public void findAll() {
		// given
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		// when
		List<Member> result = repository.findAll();
		// then
		assertThat(result.size()).isEqualTo(2);
	}
}
