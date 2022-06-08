package com.spring_management.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemVo {
	private Long bno;
	private String name;
	private String tel;
	private Date bookDate;
	private String typeCurl;
	private String typeLength;
	private String pic;
	
}
