package com.sist.web.vo;
import lombok.Data;

@Data
public class UserRolesVO {
	/*
	 * ID        NOT NULL NUMBER       
USER_ID   NOT NULL NUMBER       
ROLE_NAME NOT NULL VARCHAR2(50)
	 */
	private int id,user_id;
	private String role_name;
}
