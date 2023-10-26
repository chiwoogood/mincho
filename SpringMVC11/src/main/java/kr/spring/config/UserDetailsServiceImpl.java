package kr.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.spring.entity.CustomUser;
import kr.spring.entity.Member;
import kr.spring.repository.MemberRepositoy;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

   @Autowired
   private MemberRepositoy memberRepository;
   
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      
      Member member = memberRepository.findById(username).get();
      
      if(member == null) {
    	  throw new UsernameNotFoundException(username+"없음");
      }
      
      return new CustomUser(member);
   }

}