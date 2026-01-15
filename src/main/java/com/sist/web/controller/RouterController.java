package com.sist.web.controller;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.web.mapper.UsersMapper;
import com.sist.web.vo.UserRolesVO;
import com.sist.web.vo.UsersVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RouterController {
	private final PasswordEncoder encoder;
	private final UsersMapper mapper;
	
	@GetMapping("/")
	public String main()
	{
		return "main";
	}
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	@GetMapping("/join")
	public String join()
	{
		return "join";
	}
	@PostMapping("/join")
	public String join_ok(@ModelAttribute UsersVO vo)
	{
		vo.setPassword(encoder.encode(vo.getPassword()));
		mapper.userInsert(vo);
		UsersVO dbVO=mapper.findByUsername(vo.getUsername());
		UserRolesVO rvo=new UserRolesVO();
		rvo.setUser_id(dbVO.getId());
		rvo.setRole_name("ROLE_USER");
		mapper.userRolesInsert(rvo);
		return "redirect:/";
	}
}
