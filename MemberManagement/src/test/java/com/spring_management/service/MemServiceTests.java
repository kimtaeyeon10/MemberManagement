package com.spring_management.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring_management.domain.MemVo;
import com.spring_management.mapper.MemMapper;
import com.spring_management.mapper.MemMapperTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemServiceTests {

	@Setter(onMethod_= {@Autowired})
	private MemService service;
	
	@Test
	public void testExist() { // service 객체 주입테스트
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void enrollTests() { 
		MemVo mem = new MemVo();
		mem.setName("테스트");
		mem.setTel("010-1111-2222");
		
		service.enroll(mem);
		log.info("생성된 게시물 번호:"+mem.getBno());// mapper 게시물 번호 받아오도록 .. 
	}
	
	@Test
	public void testGetAllMem() { 
		service.getAllMem().forEach(mem -> log.info(mem));
	}
	
	@Test
	public void testGetMem() {
		log.info(service.showMem(21L));
	}
	
	@Test
	public void testDel() {
		log.info("delete!!!! "+service.delete(23L));
	}
	
	@Test
	public void testUpdate() {
		MemVo mem = service.showMem(21L);
		if(mem ==null)
			return ;
		mem.setTel("999-9999-9999");
		log.info("update !!!" + service.update(mem));
	}
}
