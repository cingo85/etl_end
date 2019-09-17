package tw.com.leadteketl.controller;

import java.util.List;
import java.util.UUID;

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
import tw.com.leadteketl.bean.t_project;
import tw.com.leadteketl.service.t_projectService;

@Api(tags = "專案表單")
@RestController
@RequestMapping(value = "/api/t_project")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class t_projectController {

	@Autowired
	t_projectService t_projectService;

	@ApiOperation(value = "取得專案", notes = "列出所有專案清單")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/queryAllproject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_project> getAllProject() {
		return t_projectService.findAll();
	}

//	@ApiOperation(value = "查看單一專案",notes = "查看單一專案")
//	@ResponseStatus(HttpStatus.OK)
//	@GetMapping(value = "/queryOneproject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public t_project getOneProject(@ApiParam(required = true, value = "專案表單") @RequestBody t_project t_project) {
//		return t_project_repository.getOne(t_project.sn);
//	}

	@ApiOperation(value = "新增專案", notes = "新增專案")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "新增專案成功") })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/createNewProject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String createNewProject(@ApiParam(required = true, value = "專案表單") @RequestBody t_project t_project) {

		String succse = null;

//		for(t_datasource item : t_project.t_datasource) {
//			item.project_id = t_project.project_id;
//		}

		t_projectService.saveNewProject(t_project);
//		if("PM".equals(t_project.user)) {
//			t_project_repository.save(t_project);
//			succse = "新增專案成功";
//		}else {
//			succse = "沒有專案經理腳色，新增專案失敗。";
//		}

		return succse;
	}

	/*
	 * 單筆修改
	 */
//	@ApiOperation(value = "更新專案", notes = "更新專案")
//	@ApiResponses(value = { @ApiResponse(code = 201, message = "更新專案成功") })
//	@ResponseStatus(HttpStatus.OK)
//	@PostMapping(value = "/updateProject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public t_project updateProject(@ApiParam(required = true, value = "專案表單") @RequestBody t_project t_project) {
//		return t_project_repository.save(t_project);
//	}

	@ApiOperation(value = "關閉專案", notes = "關閉專案")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "關閉專案成功") })
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/closeProject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String closeProject(@ApiParam(required = true, value = "專案表單") @RequestBody t_project t_project) {
		
		String succse = null;
//		if ("PM".equals(t_project.user)) {
		t_project _old_t_project = t_projectService.findBySn(t_project.sn);

		_old_t_project.isClose = true;
		t_projectService.save(_old_t_project);

//			succse = "關閉專案成功";
//		} else {
//			succse = "沒有專案經理腳色，關閉專案失敗。";
//		}

		return succse;
	}
}
