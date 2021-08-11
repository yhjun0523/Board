package com.spring.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.biz.user.UserService;
import com.spring.biz.user.UserVO;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// 회원 가입
	@RequestMapping(value = "/join.do")
	public String insertUser(UserVO vo, HttpServletRequest request) throws Exception {
		int result = userService.idChk(vo);
		try {
			if (result == 1) {
				return "join.jsp";
			} else if (result == 0) {
				userService.insertUser(vo);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return "redirect:list.do";
	}

	// 로그인
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam("userId") String id, @RequestParam("userPw") String password, UserVO vo,
			HttpSession session, Model model) {

		UserVO user = userService.login(vo);

		if (user != null) {
			if (id.equals(user.getUserId()) && password.equals(user.getUserPw()))
				session.setAttribute("userName", user.getUserName());
			return "redirect:list.do";
		} else {
			System.out.println("로그인 실패..");
			return "login.jsp";
		}
	}

	// 로그아웃
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:list.do";
	}

	// 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value = "/idChk.do", method = RequestMethod.POST)
	public int idChk(UserVO vo) throws Exception {
		System.out.println(vo);
		int result = userService.idChk(vo);
		System.out.println(result);
		return result;
	}
}
