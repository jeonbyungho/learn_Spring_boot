package com.training.membership.repository;

import com.training.membership.dto.Member;
import com.training.membership.dto.MemberJoinForm;
import com.training.membership.dto.MemberLoginForm;

public interface MemberRepository {
	public Member join(MemberJoinForm form);
	public Member login(MemberLoginForm form);
}
