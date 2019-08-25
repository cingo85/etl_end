package tw.com.leadteketl.controller;

import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tw.com.leadteketl.bean.t_table_master;
import tw.com.leadteketl.service.t_table_masterService;

@Api(tags = "資料表主表單")
@RestController
@RequestMapping(value="/api/t_table_master")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class t_table_masterController {
	
	@Autowired
	t_table_masterService t_table_masterService;
	
	@ApiOperation(value = "取得資料表主表單", notes = "列出所有資料表主表單")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/queryAlltableMaster",produces =MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_table_master> getAllProject() {
		
		return t_table_masterService.findAll();
	}
	
	
	@ApiOperation(value = "使用專案編號取得資料表主表單", notes = "列出專案資料表主表單")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/querytableMasterByProjectId",produces =MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_table_master> findByProjectId(@ApiParam(required = true, value = "專案ID") @RequestBody t_table_master t_table_master){
		
		String projectValue = t_table_master.getProjectId();
		List<t_table_master> result = t_table_masterService.findByProjectId(projectValue);
		return result;
	}
	
	@ApiOperation(value = "使用表單編號取得資料表主表單", notes = "列出專案資料表主表單")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/querytableMasterByTableId",produces =MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_table_master> findByTableId(@ApiParam(required = true, value = "專案ID") @RequestParam(value = "tableId") String tableId){
		System.out.println("inner here");
		System.out.println(tableId);
		List<t_table_master> result = t_table_masterService.findByTableId(tableId);
		return result;
	}
	
	@ApiOperation(value = "使用專案編號比較DataSourceNTableMaster", notes = "列出專案資料表主表單")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/compareDataSourceNTableMasterProjectId",produces =MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_table_master> compareDataSourceNTableMasterProjectId(@ApiParam(required = true, value = "專案ID") @RequestBody t_table_master t_table_master){
		String projectValue = t_table_master.getProjectId();
		
		List<t_table_master> result = t_table_masterService.compareDataSourceNTableMasterProjectId(projectValue);
		
		return result;
	}
	
	
	
//	@ApiOperation(value = "新增資料表主表單", notes = "新增資料表主表單")
//	@ApiResponses(value = {@ApiResponse(code=201,message = "新增資料表主表單成功")})
//	@ResponseStatus(HttpStatus.CREATED)
//	@PostMapping(value = "/createNewt_table_master", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public t_table_master createNewt_table_master(@ApiParam(required = true, value = "資料表主表單") @RequestBody t_table_master t_table_master) {
//		return t_table_masterService.save(t_table_master);
//	}
	
	/*
	 * 單筆修改
	 */

	@ApiOperation(value = "更新資料表主表單", notes = "更新代碼轉換")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "更新代碼轉換成功") })
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/updatet_table_master", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_table_master updatet_table_master(@ApiParam(required = true, value = "更新代碼轉換") @RequestBody t_table_master t_table_master) {
		System.out.println(t_table_master);
		return t_table_masterService.save(t_table_master);
//		return null;
	}
}
