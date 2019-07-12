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
import tw.com.leadteketl.bean.t_table_detail;
import tw.com.leadteketl.dao.t_table_detailRepository;

@Api(tags = "資料表邏輯表單")
@RestController
@RequestMapping(value="/api/t_table_detail")
@Controller
public class t_table_detailController {
	@Autowired
	t_table_detailRepository t_table_detailRepository;
	
	@ApiOperation(value = "取得資料表主表單", notes = "列出所有資料表主表單")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/queryAlltabledetail",produces =MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_table_detail> getAllProject() {
		return t_table_detailRepository.findAll();
	}
	
	@ApiOperation(value = "新增資料表主表單", notes = "新增資料表主表單")
	@ApiResponses(value = {@ApiResponse(code=201,message = "新增資料表主表單成功")})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/createNewtabledetail", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_table_detail createNewProject(@ApiParam(required = true, value = "資料表主表單") @RequestBody t_table_detail t_table_detail) {
		return t_table_detailRepository.save(t_table_detail);
	}
}
