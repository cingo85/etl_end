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
import tw.com.leadteketl.bean.t_method;
import tw.com.leadteketl.dao.t_methodRepository;

@Api(tags = "ETL功能列表")
@RestController
@RequestMapping(value = "/api/t_method")
@Controller
public class t_methodController {

	@Autowired
	t_methodRepository t_methodRepository;

	@ApiOperation(value = "取得ETL功能列表", notes = "列出所有ETL功能列表")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/queryAllt_method", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_method> getAllProject() {
		return t_methodRepository.findAll();
	}

	@ApiOperation(value = "新建ETL功能列表", notes = "新建ETL功能列表")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "新建ETL功能列表成功") })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/createNewt_method", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_method createNewDataBase(
			@ApiParam(required = true, value = "新建ETL功能列表") @RequestBody t_method t_method) {
		return t_methodRepository.save(t_method);
	}

	@ApiOperation(value = "更新ETL功能列表", notes = "更新ETL功能列表")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "更新ETL功能列表成功") })
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/updatet_method", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_method updateProject(@ApiParam(required = true, value = "更新ETL功能列表") @RequestBody t_method t_method) {
//			t_method.
		return t_methodRepository.save(t_method);
	}
}
