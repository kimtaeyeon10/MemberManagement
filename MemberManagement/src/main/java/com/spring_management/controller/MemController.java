package com.spring_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring_management.domain.MemVo;
import com.spring_management.service.MemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member/*")
@RequiredArgsConstructor //final
public class MemController {
	
	private final MemService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("===============list....==========");

		model.addAttribute("memList",service.getAllMem());
	}

	@PostMapping("/register")
	public String register(MemVo mem,RedirectAttributes rttr) {
		/*
		 * log.info("mem" + mem);
		 * 
		 * Long bno = service.enroll(mem);
		 * 
		 * log.info("bno:" + bno); rttr.addFlashAttribute("result",bno);
		 */
		
		return "redirect:/member/list";
	}
	
	@PostMapping("/modify")
	public String moidfy(MemVo mem, RedirectAttributes rttr) {
		if(service.update(mem)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/member/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		if(service.delete(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/member/list";
	}
}
