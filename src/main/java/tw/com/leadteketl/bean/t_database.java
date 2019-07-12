package tw.com.leadteketl.bean;

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
@Table(name="t_database")
@ApiModel(description= "資料庫表單")
@Data
public class t_database implements java.io.Serializable{


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
	@Column(name="project_id",nullable = false,unique=true,length=100)
	public String project_id;
	
	@ApiModelProperty(value = "資料庫代碼", required = true)
	@Column(name="database_id",nullable = false,unique=true,length=200)
	public String database_id;
	
	@ApiModelProperty(value = "是否為目標資料庫", required = true)
	@Column(name="is_output_database",nullable = false,length=1)
	public boolean is_output_database;
	
	@ApiModelProperty(value = "資料庫類型", required = true)
	@Column(name="database_type",nullable = false,length=100)
	public String database_type;	
	
	@ApiModelProperty(value = "資料庫IP", required = true)
	@Column(name="database_ip",nullable = false,length=200)
	public String database_ip;
	
	@ApiModelProperty(value = "資料庫PORT", required = true)
	@Column(name="database_port",nullable = true,length=100)
	public String database_port;
	
	@ApiModelProperty(value = "資料庫名稱", required = true)
	@Column(name="database_name",nullable = false,length=100)
	public String database_name;	
	
	@ApiModelProperty(value = "資料庫輪廓", required = true)
	@Column(name="database_schema_name",nullable = true,length=100)
	public String database_schema_name;	
	
	@ApiModelProperty(value = "資料庫帳號", required = true)
	@Column(name="database_user",nullable = false,length=100)
	public String database_user;	
	
	@ApiModelProperty(value = "資料庫密碼", required = true)
	@Column(name="database_password",nullable = false,length=100)
	public String database_password;	
	
	@ApiModelProperty(value = "備註", required = true)
	@Column(name="note",nullable = true,length=200)
	public String Note;	
	
	@ApiModelProperty(value = "狀態", required = true)
	@Column(name="state",nullable = false,length=10)
	public String state;
	

}
