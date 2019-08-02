package tw.com.leadteketl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tw.com.leadteketl.bean.t_member;
import tw.com.leadteketl.bean.t_switch_detail;
import tw.com.leadteketl.service.t_memberService;

@Api(tags = "人員表單")
@RestController
@RequestMapping(value="/api/t_member")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class t_memberController {
	
	@Autowired
	t_memberService t_memberService;
	
	@ApiOperation(value = "註冊", notes = "註冊")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "新增人員成功") })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/createNewmember", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createNewmember(@ApiParam(required = true, value = "新增人員表單") @RequestBody t_member t_member) {
		return t_memberService.registeredMember(t_member);
	}
	
	@ApiOperation(value = "查詢人員", notes = "查詢人員")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "查詢人員") })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/ListAllmember", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_member> ListAllmember(@ApiParam(required = true, value = "查詢人員表單") @RequestBody t_member t_member) {
		return t_memberService.ListAllMember();
	}
	
	@ApiOperation(value = "登入", notes = "登入")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "登入") })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/Login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public boolean Login(@ApiParam(required = true, value = "查詢人員表單") @RequestBody t_member t_member) {
		return t_memberService.loginMember(t_member);
	}
	
	

}
