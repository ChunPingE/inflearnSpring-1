package hello.hellospring.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;

import hello.hellospring.domain.*;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
	
	//JPQL SELECT m from Member m WHRER m.name = ?
	@Override
	Optional<Member> findByName(String name);
}
