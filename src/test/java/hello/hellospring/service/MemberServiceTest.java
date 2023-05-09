package hello.hellospring.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

import hello.hellospring.domain.*;
import hello.hellospring.repository.*;

class MemberServiceTest {

	MemberService memberService;
	MemoryMemberRepository memberRepository;

	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}

	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}

	@Test
	void join() {
		// given
		Member member = new Member();
		member.setName("hello");

		// when
		Long saveId = memberService.join(member);

		// then
		Member findMember = memberService.findOne(saveId).get();
		Assertions.assertEquals(member.getName(), findMember.getName());
	}

	@Test
	public void 중복_회원_예외() throws Exception {
		// Given
		Member member1 = new Member();
		member1.setName("spring");
		Member member2 = new Member();
		member2.setName("spring");
		// When
		memberService.join(member1);
		IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
				() -> memberService.join(member2));// 예외가 발생해야 한다.
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

		/*
		 * try { memberService.join(member2); fail("예외가 발생해야합니다."); } catch (Exception
		 * e) { assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다."); }
		 */
	}

	@Test
	void findMembers() {
	}

	@Test
	void findOne() {
	}

}
