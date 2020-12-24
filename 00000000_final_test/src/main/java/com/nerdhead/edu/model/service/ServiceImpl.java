package com.nerdhead.edu.model.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nerdhead.edu.dto.AnswerBoardDto;
import com.nerdhead.edu.dto.MemberDto;
import com.nerdhead.edu.model.dao.IBoardDao;
import com.nerdhead.edu.model.dao.IMemberDao;

@Service
public class ServiceImpl implements IService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IBoardDao boardDao;
	@Autowired
	private IMemberDao memberDao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<AnswerBoardDto> selectAll() {
		return boardDao.selectAll();
	}

	@Override
	public AnswerBoardDto selectOne(String seq) {
		return boardDao.selectOne(Integer.parseInt(seq));
	}

	@Override
	@Transactional
	public int replyinsert(AnswerBoardDto dto) {
		boardDao.replyUpdate(dto);
		return boardDao.replyinsert(dto);
	}

	@Override
	public int modifyBoard(AnswerBoardDto dto) {
		return boardDao.modifyBoard(dto);
	}

	@Override
	public int insertBoard(AnswerBoardDto dto) {
		return boardDao.insertBoard(dto);
	}

	@Override
	public int multiDelete(String seq) {
		return boardDao.multiDelete(seq);
	}

	@Override
	public int multiDelete2(Map<String, String[]> seqs) {
		return boardDao.multiDelete2(seqs);
	}

	@Override
	public boolean signUpMember(MemberDto dto) {
		String enpw=passwordEncoder.encode(dto.getPw());
		dto.setPw(enpw);
		
		return memberDao.signUpMember(dto);
	}

	@Override
	public MemberDto loginMember(String id, String pw) {
		MemberDto memberDto=null;
		String dbPw = memberDao.selStringPw(id);		//db에서 암호화된 pw 가져오기
		
		if (memberDao.idDuplicateCheck(id)				//id가 존재하고, 받아온 pw와 dp의 pw가  passwordEncoder에서 일치하면
				&&passwordEncoder.matches(pw,dbPw)) {	//로그인 정보를 가져온다
			memberDto = memberDao.loginMember(id);
		}
		log.info("ServiceImpl -> loginMember-> "+memberDto);
		return memberDto;
	}

}
