package com.spring_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring_management.service.MemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor //final
public class MemController {

	@GetMapping("/list")
	public void list() {
		log.info("list....=======");
	}
	private final MemService service;
	
	
}
