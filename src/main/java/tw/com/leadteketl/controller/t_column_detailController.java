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
import tw.com.leadteketl.bean.t_column_detail;
import tw.com.leadteketl.dao.t_column_detailRepository;

@Api(tags = "欄位邏輯表單")
@RestController
@RequestMapping(value="/api/t_column_detail")
@Controller
public class t_column_detailController {
	
	@Autowired
	t_column_detailRepository t_column_detailRepository;
	
	@ApiOperation(value = "取得所有欄位細項", notes = "取得所有欄位細項")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/queryAllcolumnDetail",produces =MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_column_detail> getAllProject() {
		return t_column_detailRepository.findAll();
	}
	
	
	@ApiOperation(value = "新建欄位細項", notes = "新建欄位細項")
	@ApiResponses(value = {@ApiResponse(code=201,message = "新建欄位細項")})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/createNewColumnDetail", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_column_detail createNewColumnDetail(@ApiParam(required = true, value = "新建欄位細項") @RequestBody t_column_detail t_column_detail) {
		return t_column_detailRepository.save(t_column_detail);
	}
	
	@ApiOperation(value = "更新欄位細項",notes = "更新欄位細項")
	@ApiResponses(value = {@ApiResponse(code=201,message = "更新欄位細項成功")})
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/updateColumnDetail", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_column_detail updateColumnDetail(@ApiParam(required = true, value = "更新欄位細項") @RequestBody t_column_detail t_column_detail) {

		return t_column_detailRepository.save(t_column_detail);
	}
}
