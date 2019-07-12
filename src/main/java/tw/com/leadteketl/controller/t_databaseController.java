package tw.com.leadteketl.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
import tw.com.leadteketl.bean.t_database;
import tw.com.leadteketl.bean.t_project;
import tw.com.leadteketl.dao.t_databaseRepository;
import tw.com.leadteketl.dao.t_table_masterRepository;
import tw.com.leadteketl.connectfunction.SQLSERVERconnTest;

@Api(tags = "資料庫表單")
@RestController
@RequestMapping(value = "/api/t_database")
@Controller
public class t_databaseController {

	@Autowired
	t_databaseRepository t_DataBaseRepository;

	@Autowired
	t_table_masterRepository t_table_masterRepository;
	
	SQLSERVERconnTest sqlserverconn = new SQLSERVERconnTest();

	@ApiOperation(value = "取得專案資料庫", notes = "列出所有專案資料庫")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/queryAlldatabase", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<t_database> getAllProject() {
		return t_DataBaseRepository.findAll();
	}

	@ApiOperation(value = "新建專案資料庫連線", notes = "新建專案資料庫連線")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "新建專案資料庫連線成功") })
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/createNewDataBase", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_database createNewDataBase(@ApiParam(required = true, value = "新建專案資料庫連線") @RequestBody t_database t_database)
			throws SQLException {
		
			return t_DataBaseRepository.save(t_database);
	
	}

	@ApiOperation(value = "更新專案資料庫連線", notes = "更新專案資料庫連線")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "更新專案資料庫連線成功") })
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/updateDataBase", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public t_database updateProject(@ApiParam(required = true, value = "專案表單") @RequestBody t_database t_database)
			throws SQLException {

		return t_DataBaseRepository.save(t_database);
	}

//	public boolean SQLSERVERconnTest(t_database t_database) throws SQLException {
//		String url = null;
//		Connection conn = null;
//		if ("".equals(t_database.database_port)) {
//			url = "jdbc:sqlserver://" + t_database.database_ip + ";";
//		} else {
//			url = "jdbc:sqlserver://" + t_database.database_ip + ":" + t_database.database_port + ";";
//		}
//		boolean conntest = false;
//		try {
//			conn = DriverManager.getConnection(url, t_database.database_user, t_database.database_password);
//			if (conn != null) {
//				conntest = true;
//				List<String> table_name = t_DataBaseRepository.findSqlserverAllDbSchema();
//				table_name.forEach(s ->System.out.println(s));
//			} else {
//				conntest = false;
//			}
//			conn.close();
//		} catch (Exception e) {
//		} finally {
//			if (conn != null) {
//				conn.close();
//			}
//		}
//
//		return conntest;
//	}

}
