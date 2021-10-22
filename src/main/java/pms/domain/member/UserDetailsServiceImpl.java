package pms.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ssooya90@naver.com on 2020-03-02
 * Github : http://github.com/ssooya90
 */

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

		// View에서 username으로 넘겨야 함..!
		Member member = memberRepository.findByUserId(userId)
				.orElseThrow(() -> new UsernameNotFoundException(userId));

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		if (userId.equals("admin")) {
			grantedAuthorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getValue()));
		} else {
			grantedAuthorities.add(new SimpleGrantedAuthority(MemberRole.MEMBER.getValue()));
		}

		return new User(member.getUserId(), member.getPassword(), grantedAuthorities);

	}

}
