package tw.com.leadteketl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
import tw.com.leadteketl.bean.t_switch_master;
import tw.com.leadteketl.dao.t_switch_masterRepository;

@Api(tags = "代碼轉換主表單")
@RestController
@RequestMapping(value = "/api/t_switch_master")
@Controller
public class t_switch_masterController {
	
	
	@Autowired
	t_switch_masterRepository t_switch_masterrepository;

	@ApiOperation(value = "取得代碼轉換", notes = "列出所有代碼轉換清單")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/queryAllt_switch_master", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_switch_master> getAllt_switch_master() {
		return t_switch_masterrepository.findAll();
	}

	@ApiOperation(value = "新增代碼轉換", notes = "新增代碼轉換")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "新增代碼轉換成功") })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/createNewt_switch_master", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_switch_master createNewt_switch_master(@ApiParam(required = true, value = "新增代碼轉換") @RequestBody t_switch_master t_switch_master) {
		return t_switch_masterrepository.save(t_switch_master);
	}

	/*
	 * 單筆修改
	 */

	@ApiOperation(value = "更新代碼轉換", notes = "更新代碼轉換")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "更新代碼轉換成功") })
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/updatet_switch_master", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_switch_master updatet_switch_master(@ApiParam(required = true, value = "更新代碼轉換") @RequestBody t_switch_master t_switch_master) {
		return t_switch_masterrepository.save(t_switch_master);
	}

}
