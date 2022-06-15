package com.spring_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_management.domain.MemVo;
import com.spring_management.mapper.MemMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemServiceImpl implements MemService{

	private MemMapper mapper;

	@Override
	public void enroll(MemVo mem) {
		log.info("enroll"+mem);
		mapper.enrollMem(mem);
		
	}

	@Override
	public MemVo showMem(Long bno) { // 멤버 상세보기
		log.info("show detail mem : " + bno);
		return mapper.getMem(bno);
	} 

	@Override
	public boolean update(MemVo mem) {
		log.info("update ..." + mem);
		return mapper.updateMem(mem)==1; // True / False 
	}

	@Override
	public boolean delete(Long bno) {
		log.info("delete..." + bno);
		return mapper.delMem(bno)==1;
	}

	@Override
	public List<MemVo> getAllMem() {
		log.info("get All Member :" );
		
		return mapper.getList();
	}
}
