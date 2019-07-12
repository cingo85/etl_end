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
import tw.com.leadteketl.bean.t_switch_detail;
import tw.com.leadteketl.dao.t_switch_detailRepository;

@Api(tags = "代碼轉換內容表單")
@RestController
@RequestMapping(value = "/api/t_switch_detail")
@Controller
public class t_switch_detailController {
	
	
	@Autowired
	t_switch_detailRepository t_switch_detailrepository;

	@ApiOperation(value = "取得代碼轉換內容", notes = "列出所有代碼轉換內容清單")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/queryAllt_switch_detail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_switch_detail> getAllt_switch_detail() {
		return t_switch_detailrepository.findAll();
	}

	@ApiOperation(value = "新增代碼轉換內容", notes = "新增代碼轉換內容")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "新增代碼轉換內容成功") })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/createNewt_switch_detail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_switch_detail createNewt_switch_detail(@ApiParam(required = true, value = "新增代碼轉換內容表單") @RequestBody t_switch_detail t_switch_detail) {
		return t_switch_detailrepository.save(t_switch_detail);
	}

	/*
	 * 單筆修改
	 */

	@ApiOperation(value = "更新代碼轉換內容", notes = "更新代碼轉換內容")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "更新代碼轉換內容成功") })
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/updatet_switch_detail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_switch_detail updatet_switch_detail(@ApiParam(required = true, value = "更新代碼轉換內容表單") @RequestBody t_switch_detail t_switch_detail) {
		return t_switch_detailrepository.save(t_switch_detail);
	}

}
