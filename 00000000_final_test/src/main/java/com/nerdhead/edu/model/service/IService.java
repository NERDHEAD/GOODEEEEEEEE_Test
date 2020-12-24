package com.nerdhead.edu.model.service;

import java.util.List;
import java.util.Map;

import com.nerdhead.edu.dto.AnswerBoardDto;
import com.nerdhead.edu.dto.MemberDto;

public interface IService {
	// selectDynamic
	public List<AnswerBoardDto> selectAll();

	public AnswerBoardDto selectOne(String seq);

	// replyinsert
	public int replyinsert(AnswerBoardDto dto);

	
	// <update id="modifyBoard" parameterType="java.util.Map">
	public int modifyBoard(AnswerBoardDto dto);

	// <insert id="insertBoard" parameterType="ADto">
	public int insertBoard(AnswerBoardDto dto);
	// <update id="multiDelete" parameterType="java.lang.String">
	public int multiDelete(String seq);

	// <update id="multiDelete2" parameterType="java.util.Map">
	public int multiDelete2(Map<String, String[]> seqs);
	
	public boolean signUpMember(MemberDto dto);
	
	public MemberDto loginMember(String id, String pw);
}
