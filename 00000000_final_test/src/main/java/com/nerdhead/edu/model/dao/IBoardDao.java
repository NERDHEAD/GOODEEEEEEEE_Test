package com.nerdhead.edu.model.dao;

import java.util.List;
import java.util.Map;

import com.nerdhead.edu.dto.AnswerBoardDto;

public interface IBoardDao {
	// selectDynamic
	public List<AnswerBoardDto> selectAll();

	public AnswerBoardDto selectOne(int seq);

	// replyinsert
	public int replyinsert(AnswerBoardDto dto);

	// <update id="replyUpdate" parameterType="ADto">
	public int replyUpdate(AnswerBoardDto dto);
	// <update id="modifyBoard" parameterType="java.util.Map">
	public int modifyBoard(AnswerBoardDto dto);

	// <insert id="insertBoard" parameterType="ADto">
	public int insertBoard(AnswerBoardDto dto);
	// <update id="multiDelete" parameterType="java.lang.String">
	public int multiDelete(String seq);

	// <update id="multiDelete2" parameterType="java.util.Map">
	public int multiDelete2(Map<String, String[]> seqs);
}
