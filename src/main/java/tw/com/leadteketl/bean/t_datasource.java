package tw.com.leadteketl.bean;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name="t_datasource")
@ApiModel(description= "資料庫表單")
//@Data
public class t_datasource implements java.io.Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "自增序號", required = true)
	@Column(name="SN",updatable = false,nullable = false,length=5)
	public Integer sn;
	
	@ApiModelProperty(value = "專案代碼", required = true)
	@Column(name="project_id",nullable = false,length=36)
	public String projectId;
	
	@ApiModelProperty(value = "資料源代碼", required = true)
	@Column(name="datasource_id",nullable = false,unique=true,length=36)
	public String datasourceId;
	
	@ApiModelProperty(value = "是否為目標資料源", required = true)
	@Column(name="is_output_datasource",nullable = true,length=1)
	public boolean is_output_datasource;
	
	@ApiModelProperty(value = "是否為來源資料源", required = true)
	@Column(name="is_input_datasource",nullable = true,length=1)
	public boolean is_input_datasource;
	
	@ApiModelProperty(value = "資料源類型", required = true)
	@Column(name="datasource_type",nullable = false,length=100)
	public String datasource_type;	
	
	@ApiModelProperty(value = "資料庫IP", required = true)
	@Column(name="database_ip",nullable = true,length=255)
	public String database_ip;
	
	@ApiModelProperty(value = "資料庫PORT", required = true)
	@Column(name="database_port",nullable = true,length=100)
	public String database_port;
	
	@ApiModelProperty(value = "資料源名稱", required = true)
	@Column(name="datasource_name",nullable = false,length=255)
	public String datasource_name;	
	
	@ApiModelProperty(value = "資料庫輪廓", required = true)
	@Column(name="database_schema_name",nullable = true,length=255)
	public String database_schema_name;	
	
	@ApiModelProperty(value = "資料庫帳號", required = true)
	@Column(name="database_user",nullable = true,length=255)
	public String database_user;	
	
	@ApiModelProperty(value = "資料庫密碼", required = true)
	@Column(name="database_password",nullable = true,length=255)
	public String database_password;	
	
	@ApiModelProperty(value = "備註", required = true)
	@Column(name="database_note",nullable = true,length=200)
	public String database_note;	
	
	@ApiModelProperty(value = "狀態", required = true)
	@Column(name="DataBaseState",nullable = true,length=40)
	public String DataBaseState;
	
	@ApiModelProperty(value = "資料根目錄", required = true)
	@Column(name="data_root",nullable = true,length=255)
	public String data_root;

	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}	


	public String getDatasourceId() {
		return datasourceId;
	}

	public void setDatasourceId(String datasourceId) {
		this.datasourceId = datasourceId;
	}

	public boolean isIs_output_datasource() {
		return is_output_datasource;
	}

	public void setIs_output_datasource(boolean is_output_datasource) {
		this.is_output_datasource = is_output_datasource;
	}

	public boolean isIs_input_datasource() {
		return is_input_datasource;
	}

	public void setIs_input_datasource(boolean is_input_datasource) {
		this.is_input_datasource = is_input_datasource;
	}

	public String getDatasource_type() {
		return datasource_type;
	}

	public void setDatasource_type(String datasource_type) {
		this.datasource_type = datasource_type;
	}

	public String getDatabase_ip() {
		return database_ip;
	}

	public void setDatabase_ip(String database_ip) {
		this.database_ip = database_ip;
	}

	public String getDatabase_port() {
		return database_port;
	}

	public void setDatabase_port(String database_port) {
		this.database_port = database_port;
	}

	public String getDatasource_name() {
		return datasource_name;
	}

	public void setDatasource_name(String datasource_name) {
		this.datasource_name = datasource_name;
	}

	public String getDatabase_schema_name() {
		return database_schema_name;
	}

	public void setDatabase_schema_name(String database_schema_name) {
		this.database_schema_name = database_schema_name;
	}

	public String getDatabase_user() {
		return database_user;
	}

	public void setDatabase_user(String database_user) {
		this.database_user = database_user;
	}

	public String getDatabase_password() {
		return database_password;
	}

	public void setDatabase_password(String database_password) {
		this.database_password = database_password;
	}



	public String getDatabase_note() {
		return database_note;
	}

	public void setDatabase_note(String database_note) {
		this.database_note = database_note;
	}


	public String getDataBaseState() {
		return DataBaseState;
	}

	public void setDataBaseState(String dataBaseState) {
		DataBaseState = dataBaseState;
	}

	public String getData_root() {
		return data_root;
	}

	public void setData_root(String data_root) {
		this.data_root = data_root;
	}


	
	

}
