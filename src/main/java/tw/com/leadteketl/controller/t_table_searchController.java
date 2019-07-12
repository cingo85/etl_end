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
import tw.com.leadteketl.bean.t_table_search;
import tw.com.leadteketl.dao.t_table_searchRepository;

@Api(tags = "資料表搜尋方式表單")
@RestController
@RequestMapping(value = "/api/t_table_search")
@Controller
public class t_table_searchController {
	
	
	@Autowired
	t_table_searchRepository t_table_searchrepository;

	@ApiOperation(value = "取得資料表搜尋方式", notes = "列出所有資料表搜尋方式清單")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/queryAllt_table_search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_table_search> getAllt_table_search() {
		return t_table_searchrepository.findAll();
	}

	@ApiOperation(value = "新增資料表搜尋方式", notes = "新增資料表搜尋方式")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "新增資料表搜尋方式成功") })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/createNewt_table_search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_table_search createNewt_table_search(@ApiParam(required = true, value = "新增資料表搜尋方式") @RequestBody t_table_search t_table_search) {
		return t_table_searchrepository.save(t_table_search);
	}

	/*
	 * 單筆修改
	 */

	@ApiOperation(value = "更新資料表搜尋方式", notes = "更新資料表搜尋方式")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "更新資料表搜尋方式成功") })
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/updatet_table_search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_table_search updatet_table_search(@ApiParam(required = true, value = "更新資料表搜尋方式") @RequestBody t_table_search t_table_search) {
		return t_table_searchrepository.save(t_table_search);
	}

}
