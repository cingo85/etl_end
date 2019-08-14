package tw.com.leadteketl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import tw.com.leadteketl.bean.t_table_master;
import tw.com.leadteketl.dao.t_table_masterRepository;

@Api(tags = "資料表主表單")
@RestController
@RequestMapping(value="/api/t_table_master")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class t_table_masterController {
	@Autowired
	t_table_masterRepository t_table_masterRepository;
	
	@ApiOperation(value = "取得資料表主表單", notes = "列出所有資料表主表單")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/queryAlltableMaster",produces =MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_table_master> getAllProject() {
		return t_table_masterRepository.findAll();
	}
	
	@ApiOperation(value = "新增資料表主表單", notes = "新增資料表主表單")
	@ApiResponses(value = {@ApiResponse(code=201,message = "新增資料表主表單成功")})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/createNewt_table_master", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_table_master createNewt_table_master(@ApiParam(required = true, value = "資料表主表單") @RequestBody t_table_master t_table_master) {
		return t_table_masterRepository.save(t_table_master);
	}
	
	/*
	 * 單筆修改
	 */

	@ApiOperation(value = "更新資料表主表單", notes = "更新代碼轉換")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "更新代碼轉換成功") })
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/updatet_table_master", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_table_master updatet_table_master(@ApiParam(required = true, value = "更新代碼轉換") @RequestBody t_table_master t_table_master) {
		System.out.println(t_table_master.getProjectId());
		
		return t_table_masterRepository.save(t_table_master);
//		return null;
	}
}
