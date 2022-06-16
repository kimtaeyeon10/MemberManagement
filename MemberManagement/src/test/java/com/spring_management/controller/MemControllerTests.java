package com.spring_management.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.spring_management.mapper.MemMapperTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}
		)
@Log4j
public class MemControllerTests {

	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testList() throws Exception {
		log.info(mockMvc.perform(
				MockMvcRequestBuilders.get("/member/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	@Test
	public void testRegister() throws Exception {
		log.info(mockMvc.perform(
				MockMvcRequestBuilders.post("/member/register")
				.param("name", "테이름")
				.param("tel", "010-7777-7777")
				)
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	@Test
	public void testModify() throws Exception {
		log.info(mockMvc.perform(
				MockMvcRequestBuilders.post("/member/modify")
				.param("bno", "24")
				.param("name", "수정함")
				.param("tel", "777-7777-7777")
				)
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	@Test
	public void testRemove() throws Exception {
		log.info(mockMvc.perform(
				MockMvcRequestBuilders.post("/member/remove")
				.param("bno", "26")
				)
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
}
