package hello.hellospring.repository;

import java.util.*;

import hello.hellospring.domain.*;

public interface MemberRepository {
	Member save(Member member);

	Optional<Member> findById(Long id);

	Optional<Member> findByName(String name);

	List<Member> findAll();
}
