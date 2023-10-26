package kr.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.spring.entity.Member;
import kr.spring.entity.Role;
import kr.spring.repository.MemberRepositoy;

@SpringBootTest
class SpringMvc11ApplicationTests {
	
	@Autowired
	private MemberRepositoy memberRepository;
	
	@Autowired
	private PasswordEncoder PasswordEncoder;
	
	
	
	@Test
	void contextLoads() {
		
		// 회원가입테스트
		Member m = new Member();
		m.setUsername("박치우");
		m.setPassword(PasswordEncoder.encode("1234"));
		m.setName("영화엉아");
		m.setRole(Role.ADMIN);
		m.setEbled(true);
		memberRepository.save(m);
	}

}
