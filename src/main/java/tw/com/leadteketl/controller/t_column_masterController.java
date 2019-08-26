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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tw.com.leadteketl.bean.t_column_master;
import tw.com.leadteketl.dao.t_column_masterRepository;
import tw.com.leadteketl.service.t_column_masterService;


@Api(tags = "欄位表單")
@RestController
@RequestMapping(value="/api/t_column_master")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class t_column_masterController {

	@Autowired
	t_column_masterService t_column_masterService;
	
	@ApiOperation(value = "取得欄位", notes = "取得欄位")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/queryAllcolumnMaster",produces =MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_column_master> getAllProject() {
		return t_column_masterService.findAll();
	}
	
	
	@ApiOperation(value = "新建欄位", notes = "新建欄位")
	@ApiResponses(value = {@ApiResponse(code=201,message = "新建欄位成功")})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/createNewColumnMaster", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_column_master createNewDataBase(@ApiParam(required = true, value = "新建欄位") @RequestBody t_column_master t_column_master) {
		return t_column_masterService.save(t_column_master);
	}
	
	@ApiOperation(value = "更新欄位",notes = "更新欄位")
	@ApiResponses(value = {@ApiResponse(code=201,message = "更新欄位成功")})
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/updateColumnMaster", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_column_master updateProject(@ApiParam(required = true, value = "更新欄位") @RequestBody t_column_master t_column_master) {
		return t_column_masterService.save(t_column_master);
	}
	
	@ApiOperation(value = "更新欄位",notes = "更新欄位")
	@ApiResponses(value = {@ApiResponse(code=201,message = "更新欄位成功")})
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/queryColumnMasterByTableId", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_column_master> queryColumnMasterByTableId(@ApiParam(required = true, value = "更新欄位") @RequestParam(value = "tableId") String tableId) {
		return t_column_masterService.findByTableId(tableId);
	}
	
}
