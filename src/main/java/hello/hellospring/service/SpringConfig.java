package hello.hellospring.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

import hello.hellospring.aop.*;
import hello.hellospring.repository.*;

@Configuration
public class SpringConfig {

	/*
	 * private final DataSource dataSource;
	 * 
	 * @Autowired private EntityManager em;
	 * 
	 * @Autowired public SpringConfig(DataSource dataSource) { this.dataSource =
	 * dataSource; }
	 */

	private final MemberRepository memberRepository;

	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Bean
	public MemberService memberService() {
		// return new MemberService(memberRepository());
		return new MemberService(memberRepository);
	}

	/*
	 * @Bean public TimeTraceAop timeTraceAop() { return new TimeTraceAop(); }
	 */

	/*
	 * @Bean public MemberRepository memberRepository() { // return new
	 * MemoryMemberRepository(); // return new JdbcMemberRepository(dataSource); //
	 * return new JdbcTemplateMemberRepository(dataSource); return new
	 * JpaMemberRepository(em); }
	 */
}
