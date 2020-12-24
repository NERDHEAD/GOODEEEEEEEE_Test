package com.nerdhead.edu.model.dao;

import java.util.Map;

import com.nerdhead.edu.dto.MemberDto;

public interface IMemberDao {
	public boolean signUpMember(MemberDto dto);		//회원가입
	public boolean idDuplicateCheck(String id);		//id 중복 체크
	public MemberDto loginMember(String id);		//로그인 -> idDuplicateCheck와 selStringPw가 true면 실행됨
	public String selStringPw(String id);			//암호화된 pw 비교를 위해 id로 pw 가져오기
}
