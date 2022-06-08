package com.spring_management.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.spring_management.domain.MemVo;

public interface MemMapper {

	public List<MemVo> getList();
	public void enrollMem(MemVo mem);
	public MemVo getMem(Long bno);
	public int delMem(Long bno);
	public int updateMem(MemVo mem);
}
