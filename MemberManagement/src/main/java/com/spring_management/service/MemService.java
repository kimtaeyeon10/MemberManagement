package com.spring_management.service;

import java.util.List;

import com.spring_management.domain.MemVo;

public interface MemService {
	
	public void enroll(MemVo mem);
	public MemVo showMem(Long bno);
	public boolean update(MemVo mem);
	public boolean delete(Long bno);
	public List<MemVo> getAllMem();

}
