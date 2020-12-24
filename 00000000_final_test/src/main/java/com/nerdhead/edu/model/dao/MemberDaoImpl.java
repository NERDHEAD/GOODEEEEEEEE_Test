package com.nerdhead.edu.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nerdhead.edu.dto.MemberDto;
@Repository
public class MemberDaoImpl implements IMemberDao{
	private final Logger log =  LoggerFactory.getLogger(this.getClass());
	private String NS = "com.nerdhead.edu.model.member.mapper.";
	
	@Autowired
	private SqlSessionTemplate session;
	
	
	@Override
	public boolean signUpMember(MemberDto dto) {
		return ((int)session.insert(NS+"signUpMember", dto)>0);
	}

	@Override
	public boolean idDuplicateCheck(String id) {
		boolean result=(int)session.selectOne(NS+"idDuplicateCheck", id)>0;
		log.info("MemberDaoImpl idDuplicateCheck -> "+result);
		return result;
	}

	@Override
	public MemberDto loginMember(String id) {
		MemberDto memberDto=session.selectOne(NS+"loginMember" , id);
		log.info("MemberDaoImpl loginMember -> memberDto : "+memberDto);
		return memberDto;
	}

	@Override
	public String selStringPw(String id) {
		String pw=(String)session.selectOne(NS+"selStringPw" , id);
		log.info("MemberDaoImpl selStringPw -> pw : "+pw);
		return pw;
	}

}
