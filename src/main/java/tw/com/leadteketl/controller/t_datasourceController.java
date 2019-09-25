package tw.com.leadteketl.controller;

import java.sql.SQLException;
import java.util.ArrayList;
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
import tw.com.leadteketl.bean.t_datasource;
import tw.com.leadteketl.dao.t_datasourceRepository;
import tw.com.leadteketl.service.t_datasourceService;

@Api(tags = "資料庫表單")
@RestController
@RequestMapping(value = "/api/t_datasource")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class t_datasourceController {


	@Autowired
	t_datasourceService t_datasourceService;

	@ApiOperation(value = "取得專案資料庫", notes = "列出所有專案資料庫")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/queryAlldatabase", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_datasource> getAllProject() {
		return t_datasourceService.findAll();
	}

	@ApiOperation(value = "新建專案資料庫連線", notes = "新建專案資料庫連線")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "新建專案資料庫連線成功") })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/createNewDataBase", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_datasource createNewDataBase(@ApiParam(required = true, value = "新建專案資料庫連線") @RequestBody t_datasource t_datasource)
			throws SQLException {
		
			return t_datasourceService.save(t_datasource);
	
	}

	@ApiOperation(value = "更新專案資料庫連線", notes = "更新專案資料庫連線")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "更新專案資料庫連線成功") })
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/updateDataBase", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_datasource updateProject(@ApiParam(required = true, value = "專案表單") @RequestBody t_datasource t_datasource)
			throws SQLException {
		return t_datasourceService.save(t_datasource);
	}
	
	@ApiOperation(value = "更新專案資料庫狀態", notes = "更新專案資料庫連線")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "更新專案資料庫連線成功") })
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/updateDataBaseState", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_datasource updateProjectState(@ApiParam(required = true, value = "專案表單") @RequestBody t_datasource t_datasource)
			throws SQLException {
		return t_datasourceService.saveState(t_datasource);
	}
	
	@ApiOperation(value = "查詢專案資料庫", notes = "查詢專案資料庫")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "查詢專案資料庫") })
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/queryDataSourceByProjectId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_datasource> queryDataSourceByProjectId(@ApiParam(required = true, value = "專案表單") @RequestBody t_datasource t_datasource){
		return t_datasourceService.findByprojectId(t_datasource.projectId);
	}

	@ApiOperation(value = "查詢輸出資料庫", notes = "查詢輸出資料庫")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "查詢專案資料庫") })
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/queryDataSourceByProjectIdWithOutPut", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_datasource> queryDataSourceByProjectIdWithOutPut(@ApiParam(required = true, value = "專案表單") @RequestBody t_datasource t_datasource){

		List<t_datasource> temp = t_datasourceService.findByprojectId(t_datasource.projectId);
		List<t_datasource> result = new ArrayList<t_datasource>();
		for(t_datasource item :temp){
			if(item.isOutputDatasource){
				result.add(item);
			}
		}
		return result;
	}



}
