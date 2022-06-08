package com.spring_management.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring_management.domain.MemVo;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemMapperTests {

	@Setter(onMethod_= @Autowired)
	private MemMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(mem -> log.info(mem));
	}
	
	@Test
	public void testenrollMem() {
		MemVo mem = new MemVo();
		mem.setName("홍길");
		mem.setTel("010-1111-5555");
	
		mapper.enrollMem(mem);
		
		log.info(mem);
	}
	
	@Test
	public void testGetMem() {
		MemVo mem = mapper.getMem(21L);
		
		log.info(mem);
	}
	
	@Test
	public void testDelMem() {
		log.info("DELETE : " + mapper.delMem(22L));
	}
	
	@Test
	public void testUpdateMem() {
		MemVo mem = new MemVo();
		mem.setBno(23L);
		mem.setName("김수정");
		mem.setTel("000-0000-0000");
		
		int count = mapper.updateMem(mem);
		log.info("UPDATE : " +count);
	}
	
}
