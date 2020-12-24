package com.nerdhead.edu.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nerdhead.edu.dto.AnswerBoardDto;
@Repository
public class BoardDaoImpl implements IBoardDao{
	private final Logger logger =  LoggerFactory.getLogger(this.getClass());
	private String NS = "com.nerdhead.edu.model.answerboard.mapper.";
			
	@Autowired
	private SqlSessionTemplate session;
	
	
	@Override
	public List<AnswerBoardDto> selectAll() {
		logger.info("BoardDaoImpl selectAll");
		return session.selectList(NS+"selectDynamic");
	}

	@Override
	public AnswerBoardDto selectOne(int seq) {
		logger.info("BoardDaoImpl selectOne");
		return (AnswerBoardDto) session.selectList(NS+"selectDynamic", seq).get(0);
	}

	@Override
	public int replyinsert(AnswerBoardDto dto) {
		logger.info("BoardDaoImpl selectAll");
		return session.insert(NS+"replyinsert", dto);
	}

	@Override
	public int replyUpdate(AnswerBoardDto dto) {
		logger.info("BoardDaoImpl replyUpdate");
		return session.update(NS+"replyUpdate", dto);
	}

	@Override
	public int modifyBoard(AnswerBoardDto dto) {
		logger.info("BoardDaoImpl modifyBoard");
		return session.update(NS+"modifyBoard", dto);
	}

	@Override
	public int insertBoard(AnswerBoardDto dto) {
		logger.info("BoardDaoImpl insertBoard");
		return session.insert(NS+"insertBoard", dto);
	}

	@Override
	public int multiDelete(String seq) {
		logger.info("BoardDaoImpl multiDelete");
		return session.update(NS+"multiDelete", seq);
	}

	@Override
	public int multiDelete2(Map<String, String[]> seqs) {
		logger.info("BoardDaoImpl multiDelete2");
		return session.update(NS+"multiDelete2", seqs);
	}

}
