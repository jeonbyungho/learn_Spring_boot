package com.training.login.domain.members;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * 스프링 시큐리티에 등록하여 사용할 UserSecurityService는 스프링 시큐리티가 제공하는 
 * UserDetailsService 인터페이스를 구현(implements)해야 한다. 
 */
@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService{
   
   private final MemberRepository memberRepository;
   private final PasswordEncoder passwordEncoder;

   /**
    * 보안을 위해 BCryptPasswordEncoder 클래스를 사용하여 암호화하여 비밀번호를 저장했다.
    */
   public Member join(Member member){
      String encodingPassword = passwordEncoder.encode(member.getPassword());
      member.setPassword(encodingPassword);
      return memberRepository.save(member);
   }

   /**
    * 
    */
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Member loginMember = memberRepository.findByLoginId(username);
      
      if(loginMember == null) throw new UsernameNotFoundException("회원을 찾을 수 없습니다.");
      System.out.println("Authority " + loginMember.toString());

      List<GrantedAuthority> authoritys = new ArrayList<GrantedAuthority>();
      authoritys.add(new SimpleGrantedAuthority(MemberRole.USER.getValue()));

      return new User(loginMember.getLoginId(), loginMember.getPassword(), authoritys);
   }
   
}
